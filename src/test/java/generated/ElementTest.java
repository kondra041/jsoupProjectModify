[PYTHON]
def test_append_child_to_last_child():
    parent = Element("parent")
    child1 = Element("child1")
    child2 = Element("child2")
    parent.appendChild(child1)
    parent.appendChild(child2)
    assert parent.children == [child1, child2]

def test_append_child_to_middle_child():
    parent = Element("parent")
    child1 = Element("child1")
    child2 = Element("child2")
    child3 = Element("child3")
    parent.appendChild(child1)
    parent.appendChild(child2)
    parent.appendChild(child3)
    assert parent.children == [child1, child2, child3]

def test_append_child_to_first_child():
    parent = Element("parent")
    child1 = Element("child1")
    child2 = Element("child2")
    parent.appendChild(child1)
    parent.appendChild(child2)
    assert parent.children == [child1, child2]

def test_append_child_to_empty_parent():
    parent = Element("parent")
    child = Element("child")
    parent.appendChild(child)
    assert parent.children == [child]
[/PYTHON]