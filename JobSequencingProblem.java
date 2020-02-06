import java.util.*;
import java.util.stream.Stream;

class JobSequencingProblem {

    private int maxProfit;
    private ArrayList<Job> jobSequence = new ArrayList<Job>();

    private int compute_profit(int[][] jobs) {
        int maxDeadline = 0;
        int[] occupancyStatus;
        for (int[] job : jobs) {
            Job j = new Job();
            j.id = job[0];
            j.deadline = job[1];
            j.profit = job[2];
            jobSequence.add(j);
        }

        //Find the max deadline among the jobs so that only those number of jobs are allowed to be picked
        Stream<Job> stream = jobSequence.stream();
        Optional<Job> optionalJob = (stream.max(Comparator.comparing(Job::getDeadline)));
        if(optionalJob.isPresent()) {
            Job jobWithMaxDeadline = optionalJob.get();
            maxDeadline = jobWithMaxDeadline.getDeadline();
        }
        occupancyStatus = new int[maxDeadline];
        //Initialize occupancy status of jobs to -1
        Arrays.fill(occupancyStatus, -1);

        for (Job jobToBeInserted : jobSequence) {
            int deadline = jobToBeInserted.getDeadline()-1;
            //Until a position before deadline is not occupied repeat
            for(int i = deadline;i>=0;i--) {
                if(occupancyStatus[i] == -1) {
                    //Allot job and add the profit
                    occupancyStatus[i] = jobToBeInserted.getId();
                    this.maxProfit += jobToBeInserted.getProfit();
                    break;
                }
            }            
        }

        return this.maxProfit;
    }
    public static void main(String[] args) {
        int[][] jobs = new int[7][7];
        jobs[0] = new int[]{1,3,35};
        jobs[1] = new int[]{2,4,30};
        jobs[2] = new int[]{3,4,25};
        jobs[3] = new int[]{4,2,20};
        jobs[4] = new int[]{5,3,15};
        jobs[5] = new int[]{6,1,12};
        jobs[6] = new int[]{7,2,5};
        JobSequencingProblem jsp = new JobSequencingProblem();
        System.out.println("Max profit is "+jsp.compute_profit(jobs));
    }
}


class Job {
    int id;
    int deadline;
    int profit;
    int getId() {
        return this.id;
    }
    int getDeadline() {
        return this.deadline;
    }
    int getProfit() {
        return this.profit;
    }
}