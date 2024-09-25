class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None


class LRUCache:
    def __init__(self, capacity):
        self.size = capacity
        self.cache = {}
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left

    def remove(self, node):
        node.prev.next, node.next.prev = node.next, node.prev
        return node

    def insert(self, node):
        # Insert a node to the right most end of the linked list
        node.next, node.prev, self.right.prev.next, self.right.prev = (
            self.right,
            self.right.prev,
            node,
            node,
        )
        return node

    def get(self, key) -> int:
        if key in self.cache:
            self.remove(self.cache[key])
            self.insert(self.cache[key])
            return self.cache[key].val
        return -1

    def put(self, key, value) -> None:
        if key in self.cache:
            self.remove(self.cache[key])
        elif self.size == len(self.cache.keys()):
            del self.cache[self.left.next.key]
            self.remove(self.left.next)
        self.cache[key] = self.insert(Node(key, value))
        return None


obj = LRUCache(4)
obj.put(1, 2)
obj.put(3, 2)
obj.put(4, 2)
obj.put(5, 2)
obj.put(7, 2)
param_1 = obj.get(1)
print(param_1)
