```java
package generated;

/**
 * Parses HTML into a {@link Document}. Generally best to use one of the  more convenient parse methods in {@link org.jsoup.Jsoup}.
 *
 * @author Jonathan Hedley, jonathan@hedley.net
 */
public class Parser {

    private static final String SQ = "'";

    private static final String DQ = "\"";

    private static final Tag htmlTag = Tag.valueOf("html");

    private static final Tag headTag = Tag.valueOf("head");

    private static final Tag bodyTag = Tag.valueOf("body");

    private static final Tag titleTag = Tag.valueOf("title");

    private static final Tag textareaTag = Tag.valueOf("textarea");

    private final LinkedList<Element> stack;

    private final TokenQueue tq;

    private final Document doc;

    private String baseUri;

    private Parser(String html, String baseUri, boolean isBodyFragment) {
        Validate.notNull(html);
        Validate.notNull(baseUri);
        stack = new LinkedList<Element>();
        tq = new TokenQueue(html);
        this.baseUri = baseUri;
        if (isBodyFragment) {
            doc = Document.createShell(baseUri);
            stack.add(doc.body());
        } else {
            doc = new Document(baseUri);
            stack.add(doc);
        }
    }

    /**
     *     Parse HTML into a Document.
     *     @param html HTML to parse
     *     @param baseUri base URI of document (i.e. original fetch location), for resolving relative URLs.
     *     @return parsed Document
     */
    public static Document parse(String html, String baseUri) {
        Parser parser = new Parser(html, baseUri, false);
        return parser.parse();
    }

    /**
     *     Parse a fragment of HTML into the {@code body} of a Document.
     *     @param bodyHtml fragment of HTML
     *     @param baseUri base URI of document (i.e. original fetch location), for resolving relative URLs.
     *     @return Document, with empty head, and HTML parsed into body
     */
    public static Document parseBodyFragment(String bodyHtml, String baseUri) {
        Parser parser = new Parser(bodyHtml, baseUri, true);
        return parser.parse();
    }

    private Document parse() {
        while (!tq.isEmpty()) {
            if (tq.matches("<!--")) {
                parseComment();
            } else if (tq.matches("<![CDATA[")) {
                parseCdata();
            } else if (tq.matches("<?") || tq.matches("<!")) {
                parseXmlDecl();
            } else if (tq.matches("</")) {
                parseEndTag();
            } else if (tq.matches("<")) {
                parseStartTag();
            } else {
                parseTextNode();
            }
        }
        return doc.normalise();
    }

    private void parseComment() {
        tq.consume("<!--");
        String data = tq.chompTo("->");
        if (// i.e. was -->
        data.endsWith("-"))
            data = data.substring(0, data.length() - 1);
        Comment comment = new Comment(data, baseUri);
        last().appendChild(comment);
    }

    private void parseXmlDecl() {
        tq.consume("<");
        // <? or <!, from initial match.
        Character firstChar = tq.consume();
        boolean procInstr = firstChar.toString().equals("!");
        String data = tq.chompTo(">");
        XmlDeclaration decl = new XmlDeclaration(data, baseUri, procInstr);
        last().appendChild(decl);
    }

    private void parseEndTag() {
        tq.consume("</");
        String tagName = tq.consumeWord();
        tq.chompTo(">");
        if (tagName.length() != 0) {
            Tag tag = Tag.valueOf(tagName);
            popStackToClose(tag);
        }
    }

    private void parseStartTag() {
        tq.consume("<");
        String tagName = tq.consumeWord();
        if (tagName.length() == 0) {
            // doesn't look like a start tag after all; put < back on stack and handle as text
            tq.addFirst("&lt;");
            parseTextNode();
            return;
        }
        Attributes attributes = new Attributes();
        while (!tq.matchesAny("<", "/>", ">") && !tq.isEmpty()) {
            Attribute attribute = parseAttribute();
            if (attribute != null)
                attributes.put(attribute);
        }
        Tag tag = Tag.valueOf(tagName);
        Element child = new Element(tag, baseUri, attributes);
        // empty element if empty tag (e.g. img) or self-closed el (<div/>
        boolean isEmptyElement = tag.isEmpty();
        if (tq.matchChomp("/>")) {
            // close empty element or tag
            isEmptyElement = true;
        } else {
            tq.matchChomp(">");
        }
        // pc data only tags (textarea, script): chomp to end tag, add content as text node
        if (tag.isData()) {
            String data = tq.chompTo("</" + tagName);
            tq.chompTo(">");
            Node dataNode;
            if (// want to show as text, but not contain inside tags (so not a data tag?)
            tag.equals(titleTag) || tag.equals(textareaTag))
                dataNode = TextNode.createFromEncoded(data, baseUri);
            else
                // data not encoded but raw (for " in script)
                dataNode = new DataNode(data, baseUri);
            child.appendChild(dataNode);
        }
        // <base href>: update the base uri
        if (child.tagName().equals("base")) {
            String href = child.absUrl("href");
            if (href.length() != 0) {
                // ignore <base target> etc
                baseUri = href;
                // set on the doc so doc.createElement(Tag) will get updated base
                doc.setBaseUri(href);
            }
        }
        addChildToParent(child, isEmptyElement);
    }

    private Attribute parseAttribute() {
        tq.consumeWhitespace();
        String key = tq.consumeAttributeKey();
        String value = "";
        tq.consumeWhitespace();
        if (tq.matchChomp("=")) {
            tq.consumeWhitespace();
            if (tq.matchChomp(SQ)) {
                value = tq.chompTo(SQ);
            } else if (tq.matchChomp(DQ)) {
                value = tq
}