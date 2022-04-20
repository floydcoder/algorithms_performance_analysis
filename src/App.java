/**
 * Marco Stevanella - 101307949
 * COMP 2080 - ASGMT_1 (10%)
 * Prof. Andrew Rudder
 *
 * Notes: HI prof Rudder, this assignment was vey fun to do. I created a menu that lets the
 * user (you) choose the size of the array you want to test. I hope you will like the program.
 */

public class App {

    public static void main(String[] args) {

        // Create CoreData obj
        CoreData coreData = new CoreData();
        // fill the CoreData
        coreData.fillArray();
        // Create the CoreData Objects by the wanted size
        CoreData[] sizedCoreData = Tester.arraySizeBuilder(coreData);
        // copy CoreData objects for testing
        CoreData[][] testCoreData = Tester.arrayCopierBySize(sizedCoreData);
        // executes the sorts and searches tests
        Tester.testCoreData(testCoreData);

    }
}
