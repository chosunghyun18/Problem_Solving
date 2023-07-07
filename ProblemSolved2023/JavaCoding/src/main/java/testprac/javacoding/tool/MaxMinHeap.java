package testprac.javacoding.tool;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxMinHeap {
        private PriorityQueue<Integer> leftHeap;
        private PriorityQueue<Integer> rightHeap;

        public MaxMinHeap(){
            leftHeap = new PriorityQueue<>(10, Collections.reverseOrder());//최대값;
            rightHeap = new PriorityQueue<>();//최소값
        }


        public void push(int v){
            leftHeap.add(v);
        }

        public void removeMax(){

            while(!rightHeap.isEmpty()){
                leftHeap.add(rightHeap.poll());
            }

            leftHeap.poll();
        }

        public void removeMin(){

            while(!leftHeap.isEmpty()){
                rightHeap.add(leftHeap.poll());
            }

            rightHeap.poll();
        }

        public int getMaxValue(){

            if(leftHeap.size() == 0 && rightHeap.size() == 0)
                return 0;

            while(!rightHeap.isEmpty()){
                leftHeap.add(rightHeap.poll());
            }

            return leftHeap.peek();
        }

        public int getMinValue(){

            if(leftHeap.size() == 0 && rightHeap.size() == 0)
                return 0;

            while(!leftHeap.isEmpty()){
                rightHeap.add(leftHeap.poll());
            }

            return rightHeap.peek();
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("Max-Min Heap: [");

            // Append elements from the leftHeap
            for (int num : leftHeap) {
                sb.append(num).append(", ");
            }

            // Append elements from the rightHeap
            for (int num : rightHeap) {
                sb.append(num).append(", ");
            }

            // Remove the trailing comma and space if there are elements
            if (!leftHeap.isEmpty() || !rightHeap.isEmpty()) {
                sb.delete(sb.length() - 2, sb.length());
            }

            sb.append("]");
            return sb.toString();
        }
}
