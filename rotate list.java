/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        // Handle edge cases: empty list, single node, or no rotation
        if (!head || !head->next || k == 0) return head;

        // 1. Find the length of the list and the tail node
        ListNode* tail = head;
        int len = 1;
        while (tail->next) {
            tail = tail->next;
            len++;
        }

        // 2. Adjust k (if k > len, we only need k % len rotations)
        k = k % len;
        if (k == 0) return head;

        // 3. Connect tail to head to make it a circular list
        tail->next = head;

        // 4. Find the new tail: it's at (len - k - 1) steps from head
        ListNode* newTail = head;
        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail->next;
        }

        // 5. The new head is the node after the new tail
        ListNode* newHead = newTail->next;
        newTail->next = nullptr; // Break the circle

        return newHead;
    }
};
