package base.model;

import java.util.ArrayList;

/* Data model created to deserialize from the json httpResponse coming from the 
 * GET-endpoint http://localhost:9000/json/mockData.json 
 * 
 * ********************Model Details - Referenced from the QA Challenge WebSite**************************************************
 * 	Title � Text
 *	Division - Text
 *	Project Owner - Text
 *	Budget � Number, should be displayed as dollars: $XXX.XX
 *	Status - Text
 *	Created Date � date: MM/DD/YYYY
 *	Modified Date � date: MM/DD/YYYY
 * */

public class DataModel 
{
    private String division;
    private String project_owner;
    private String created;
    private String modified;
    private String title;
    private String budget;
    private String status;

    public String getDivision ()
    {
        return division;
    }

    public void setDivision (String division)
    {
        this.division = division;
    }

    public String getProject_owner ()
    {
        return project_owner;
    }

    public void setProject_owner (String project_owner)
    {
        this.project_owner = project_owner;
    }

    public String getCreated ()
    {
        return created;
    }

    public void setCreated (String created)
    {
        this.created = created;
    }

    public String getModified ()
    {
        return modified;
    }

    public void setModified (String modified)
    {
        this.modified = modified;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getBudget ()
    {
        return budget;
    }

    public void setBudget (String budget)
    {
        this.budget = budget;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [division = "+division+", project_owner = "+project_owner+", created = "+created+", modified = "+modified+", title = "+title+", budget = "+budget+", status = "+status+"]";
    }
}