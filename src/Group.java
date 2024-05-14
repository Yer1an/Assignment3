public class Group{

    private String groupName;

    public Group(String groupName){
        this.groupName = groupName;
    }
    public void setGroupName(String groupName){
        this.groupName = groupName;
    }
    public String getGroupName(){
        return groupName;
    }
    @Override
    public int hashCode(){
        int hashCode = 0;
        for(int i = 0; i < groupName.length(); i++){
            hashCode += (groupName.charAt(i) - '0');
        }
        hashCode = hashCode * 2006 + 2 + 16;
        return hashCode;
    }
}
