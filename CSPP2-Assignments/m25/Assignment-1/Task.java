/**.
 * This is task
 */
public class Task {
    /**.
     * This is title
     */
    private String title;
    /**.
     * This is assignedTo
     */
    private String assignedTo;
    /**.
     * This is time
     */
    private int timeToComplete;
    /**.
     * This is important flag
     */
    private boolean important ;
    /**.
     * This is urgent flag
     */
    private boolean urgent;
    /**.
     * This si status
     */
    private String status;
    /**.
     * This si task constructor
     *
     * @param      t      { task name }
     * @param      a      { name }
     * @param      time   time
     * @param      imp    imp flag
     * @param      urg    urg flag
     * @param      statu  status flag
     */
    Task(String t, String a, int time, boolean imp, boolean urg, String statu) throws Exception {
        if (t.length() != 0) {
            this.title = t;
        } else {
            throw new Exception("Title not provided");
        }
        this.assignedTo = a;
        if (time >= 0) {
            this. timeToComplete = time;
        } else {
            throw new Exception("Invalid timeToComplete " + time);
        }
        this.important = imp;
        this.urgent = urg;
        if (statu.equals("todo") || statu.equals("done")) {
            this.status = statu;
        } else {
            throw new Exception("Invalid status " + statu);
        }
    }
    /**.
     * This is getname 
     *
     * @return     The name.
     */
    public String getName() {
        return this.assignedTo;
    }
    /**.
     * This is getimportant
     *
     * @return     The important.
     */
    public boolean getImportant() {
        return this.important;
    }
    /**.
     * This is getUrgent
     *
     * @return     The urgent.
     */
    public boolean getUrgent() {
        return this.urgent;
    }
    /**.
     * This is get status
     *
     * @return     The status.
     */
    public String getStatus() {
        return this.status;
    }
    /**.
     * This is getTime
     *
     * @return     The time.
     */
    public int getTime() {
        return this.timeToComplete;
    }
    /**.
     * This is toString function
     */
    public void tostring() {
        String urgentflag;
        String importantflag;

        if (urgent == true) {
            urgentflag = "Urgent";
        } else {
            urgentflag = "Not Urgent";
        }
        if (important == true) {
            importantflag = "Important";
        } else {
            importantflag = "Not Important";
        }

        System.out.println(title +
            ", " + assignedTo + ", "
            + timeToComplete + ", "
            + importantflag + ", "
            + urgentflag + ", "
            + status);
        
    }
    /**.
     * this is getPrint funtiocn
     *
     * @return     The print.
     */
    public String getPrint() {
        String urgentflag;
        String importantflag;

        if (urgent == true) {
            urgentflag = "Urgent";
        } else {
            urgentflag = "Not Urgent";
        }
        if (important == true) {
            importantflag = "Important";
        } else {
            importantflag = "Not Important";
        }
        return title + ", " + assignedTo
        + ", " + timeToComplete + ", " + importantflag
        + ", " + urgentflag + ", " + status;
    }
}