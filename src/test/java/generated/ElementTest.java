[PYTHON]
def test_get_class_names():
    element = Element("div", {"class": "header gray"})
    assert element.get_class_names() == ["header", "gray"]

def test_add_class_name():
    element = Element("div", {"class": "header"})
    element.add_class_name("gray")
    assert element.get_class_names() == ["header", "gray"]

def test_remove_class_name():
    element = Element("div", {"class": "header gray"})
    element.remove_class_name("gray")
    assert element.get_class_names() == ["header"]

def test_toggle_class_name():
    element = Element("div", {"class": "header gray"})
    element.toggle_class_name("gray")
    assert element.get_class_names() == ["header"]

    element.toggle_class_name("gray")
    assert element.get_class_names() == ["header", "gray"]
[/PYTHON]