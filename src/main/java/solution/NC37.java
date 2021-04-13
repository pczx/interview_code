package solution;

import java.util.ArrayList;
import java.util.Collections;

public class NC37 {
    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return ans;
        }
        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        ans.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval pre = ans.get(ans.size() - 1);
            Interval interval = intervals.get(i);
            if (interval.start > pre.end) {
                ans.add(interval);
            } else if (interval.start == pre.end) {
                pre.end = interval.end;
            } else if (interval.end > pre.end) {
                pre.end = interval.end;
            }
        }
        return ans;
    }
}
