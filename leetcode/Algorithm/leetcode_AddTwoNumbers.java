import java.math.BigInteger;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = new ArrayList<>();
        List<Integer> l2List = new ArrayList<>();

        int l1Num = l1.val;
        ListNode l1Node = l1.next;
        l1List.add(l1Num);
        while(true){
            if(l1Node==null)
                break;
            
            l1Num = l1Node.val;
            l1Node = l1Node.next;

            l1List.add(l1Num);
        }

        int l2Num = l2.val;
        ListNode l2Node = l2.next;
        l2List.add(l2Num);
        while(true){
            if(l2Node==null)
                break;
            
            l2Num = l2Node.val;
            l2Node = l2Node.next;

            l2List.add(l2Num);
        }

        StringBuilder sbL1 = new StringBuilder();
        StringBuilder sbL2 = new StringBuilder();

        for(int idx = l1List.size()-1; idx>=0; idx--)
            sbL1.append(l1List.get(idx));
        for(int idx = l2List.size()-1; idx>=0; idx--)
            sbL2.append(l2List.get(idx));

        BigInteger intL1 = new BigInteger(sbL1.toString());
        BigInteger intL2 = new BigInteger(sbL2.toString());

        BigInteger ans = intL1.add(intL2);
        String ansStr = ans.toString();

        ListNode answerNode;
        if(ansStr.length()==1)
            answerNode = new ListNode(ansStr.charAt(ansStr.length()-1)-'0');
        else{
            answerNode = new ListNode(ansStr.charAt(ansStr.length()-1)-'0', new ListNode());
            ListNode nextNode = answerNode.next;

            for(int idx = ansStr.length()-2; idx>=0; idx--){
                nextNode.val = ansStr.charAt(idx) - '0';
                ListNode nnextNode = new ListNode();
                if(idx==0)
                    break;
                nextNode.next = nnextNode;
                nextNode = nnextNode;
            }
        }

        return answerNode;
    }
}