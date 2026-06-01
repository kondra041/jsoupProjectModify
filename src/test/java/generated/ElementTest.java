[PYTHON]
def get_deepest_child(element):
    if len(element.children) == 0:
        return element
    else:
        return get_deepest_child(element.children[0])
[/PYTHON]