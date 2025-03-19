package Tests;

import org.testng.annotations.DataProvider;

public class dataForTests
{
    //helps to write data driven tests
    @DataProvider(name = "Data Provider")
    //using data driven testing. provide data beforehand to avoid changing everytime.
    //Oject [][] is a return type that returns 2 columns(fname, lname)
    public Object [][] dataForPost()
    {
//        Object [][] data = new Object[2][3]; //creates an object that takes column wise data)
//
//        data[0][0] = "Yazdaan123"; //0th column 0th row value
//        data[0][1] = "Ali";
//        data[0][2] = 2;
//
//        data[1][0] = "Zayden234";
//        data[1][1] = "Shah";
//        data[1][2] = 1;
//
//        return data;

        //Alternate method to store data
        return new Object[][]{
                {"Yaz", "obj", 1},
                {"Zar", "onj", 2}
        };
    }

    @DataProvider(name = "DeleteData")
    public Object[] dataForDelete()
    {
        return new Object[]{
                4,5,6,7,8,9
        };
    }


}
