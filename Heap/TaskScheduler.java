import java.util.*;

class Pair4{
    int freq;
    char task;
    Pair4(char task, int freq){
        this.task = task;
        this.freq = freq;
    }
}
class Cooldown{
    Pair4 pair;
    int at;
    Cooldown(Pair4 pair, int at){
        this.pair = pair;
        this.at  = at;
    }
}
class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> map = new HashMap<>();
        for(char ch: tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair4> pq = new PriorityQueue<>(
            (p1,p2)->{
                return Integer.compare(p2.freq, p1.freq);
            }
        );

        Queue<Cooldown> q = new ArrayDeque<>();

        for(var v: map.entrySet()){
            pq.offer(new Pair4(v.getKey(), v.getValue()));
        }

        int time=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;

            // here we bring back whose waiting time is over to the maxheap //remember we didn't use that only bring back
            while(!q.isEmpty() && q.peek().at==time){
                pq.offer(q.poll().pair);
            }
            if(!pq.isEmpty()){
                Pair4 curr = pq.poll();
                curr.freq--;
                if(curr.freq>0){
                    q.offer(new Cooldown(curr, time + n + 1));
                }else{
                    // means freq over --- task completed;
                    // since removed from pq and we will not push in queue
                }
            }
        }
        return time;

    }
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'},2));
    }

}


/*Algorithm (Cooldown First)
Step 1: Count the frequency of every task.

Example:

A A A B B B C

A → 3
B → 3
C → 1
Step 2: Put every task (task, frequency) into a max heap.

The heap always gives the task with the highest remaining frequency.

Step 3: Create an empty queue for tasks that are cooling down.

Each queue element stores:

the task
its remaining frequency
the time when it becomes available again
Step 4: Initialize
time = 0
Step 5: Repeat until both the heap and cooldown queue are empty.
(a) Move time forward
time++

A new CPU interval starts.

(b) Bring back all tasks whose cooldown has finished.

While the front of the cooldown queue has

availableTime == time

remove it from the queue and insert it back into the max heap.

These tasks are now eligible to be scheduled.

(c) Execute one task.

If the heap is not empty:

Remove the task with the highest frequency.
Execute it.
Decrease its frequency by 1.

If its frequency is still greater than 0:

Put it into the cooldown queue.
Its next available time is
time + n + 1

because it must wait for n full intervals before it can be executed again.

If the heap is empty, the CPU remains idle during this interval.

Step 6

When both the heap and cooldown queue become empty,

return time.

Why time + n + 1?

Suppose

n = 2

At

Time 1

we execute

A

The next two intervals

Time 2
Time 3

must not contain A.

Therefore A can be executed again only at

Time 4

which is

1 + 2 + 1 = 4

Hence,

availableTime = time + n + 1
Summary
Count frequencies
        ↓
Build Max Heap
        ↓
Create Cooldown Queue
        ↓
time = 0
        ↓
While(heap not empty OR queue not empty)

    time++

    Move all cooled tasks from queue → heap

    If heap not empty
         Execute highest-frequency task
         Decrease frequency
         If frequency > 0
              Put into cooldown queue
              availableTime = time + n + 1

Return time
*/


/*
621. Task Scheduler
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

Return the minimum number of CPU intervals required to complete all tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2

Output: 8

Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.

After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

Example 2:

Input: tasks = ["A","C","A","B","D","B"], n = 1

Output: 6

Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.

With a cooling interval of 1, you can repeat a task after just one other task.

Example 3:

Input: tasks = ["A","A","A", "B","B","B"], n = 3

Output: 10

Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.

There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

 

Constraints:

1 <= tasks.length <= 104
tasks[i] is an uppercase English letter.
0 <= n <= 100
 

*/
