# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

from typing import Optional


class LinkedList:
    def __init__(self, head=None):
        if head is not None:
            self.head = ListNode(head)
            self.curr = self.head
        else:
            self.head = None
            self.curr = None

    def insert(self, val):
        if self.head is None:
            self.head = ListNode(val)
            self.curr = self.head
        else:
            self.curr.next = ListNode(val)
            self.curr = self.curr.next

    def print(self):
        temp = self.head
        while temp is not None:
            print(temp.val, end=" -> ")
            temp = temp.next
        print("None")


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.subReverseList(None, head)

    def subReverseList(self, prev, current):
        if current is None:
            return prev
        h = self.subReverseList(current, current.next)
        current.next = prev
        return h


l = LinkedList(1)
l.insert(2)
l.insert(3)
l.print()

sol = Solution()
l.head = sol.reverseList(l.head)
l.print()
