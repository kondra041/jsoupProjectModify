public Element prependChild(Node child) {
    Validate.notNull(child);
    child.setParentNode(this);
    childNodes.add(0, child);
    return this;
}