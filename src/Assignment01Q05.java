public class Assignment01Q05 {
    public static int findShortestPath(int[][] m, int i, int j) {
        // The shortest path from a vertex to itself is 0
        if (i == j){
            return 0;
        }

        //init arrays for help and parameters
        int leng = m.length;
        //is_visit show you if you see the node before (1) or not (0)
        int[] is_visit = new int[leng];
        //save the dist from i to each node, or -1 if there is no path yet 
        int[] dist_from_start = new int[leng];
        for (int a = 0; a <= leng -1; ++a){
            dist_from_start[a] = -1;
        }
        //order_of_visits helps to visit all the vertice we meet in order
        int[] order_of_visits = new int[leng];
        int pointer = 0;//which visit we should do now
        int end_of_order = 0;//the total num of visits
        //first vertice
        int curr_v = i;//the current vertice
        order_of_visits[0] = i;
        is_visit[curr_v] = 1;
        dist_from_start[curr_v] = 0;
        //start to loop of finding edges from each vertice
        while (pointer <= end_of_order){
            curr_v = order_of_visits[pointer];//
            for (int a = 0; a <= leng -1; ++a){
                if (is_visit[a] == 0){
                    if (m[curr_v][a] == 1){
                        is_visit[a] = 1;//we gonna visit vertice a
                        order_of_visits[end_of_order + 1] = a;// a got a number in the line of visits
                        end_of_order += 1;//the total num of visits increase by one
                        dist_from_start[a] = dist_from_start[curr_v] + 1;//the shortest dist to curr_v plus one
                    }
                }   
            }
            pointer += 1;//we finish to check a, is time to next in the line
        }
        return dist_from_start[j];//return the sothest path from i to j
    }

    public static void main(String[] args) {
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 0, 1)); // -1
        System.out.println(
            findShortestPath(new int[][]{{0,0,0}, {0,0,0}, {0,0,0}}, 1, 1)); // 0
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,0}}, 0, 2)); // 2
        System.out.println(
            findShortestPath(new int[][]{{0,1,0,1}, {0,0,0,1}, {0,0,0,0}, {0,0,1,0}}, 0, 2)); // 2
    }
}