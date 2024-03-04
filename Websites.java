// This is windows only, Chrome path is hard coded.
// Clear screen is not implemented.
// Both of these are on the todo list.

import java.util.Scanner;

public class Websites {

    public static void main(String[] args) {

        boolean running = true;
        while (running == true) {

            String[] tools = {
                    "http://urlquery.net/",
                    "https://urlscan.io/",
                    "https://www.virustotal.com/",
                    "https://www.hybrid-analysis.com/",
                    "https://www.google.com/transparencyreport/safebrowsing/diagnostic/",
                    "https://www.ssllabs.com/",
                    "https://mxtoolbox.com/",
                    "http://csi.websense.com/",
                    "http://toolbar.netcraft.com/site_report"
            };

            String[] news = {
                    "https://www.bellingcat.com/",
                    "https://www.darkreading.com/",
                    "https://nakedsecurity.sophos.com/",
                    "https://infospectives.co.uk/",
                    "https://www.scmagazine.com/",
                    "http://www.itsecurityguru.org/",
                    "https://www.wired.com/category/threatlevel/",
                    "https://www.fifthdomain.com/?source=dfn-nav",
                    "https://isc.sans.edu/",
                    "https://hackernoon.com/",
                    "https://www.thecyberwire.com/current.html"
            };

            String[] blogs = {
                    "https://www.j4vv4d.com/blog/",
                    "https://krebsonsecurity.com/",
                    "https://www.schneier.com/",
                    "https://www.endgame.com/blog/",
                    "https://blog.cyberint.com/",
                    "https://blog.aquasec.com/",
                    "https://blogs.gartner.com/blog/category/security/"
            };

            System.out.println("================ Infosec Menu ================");
            System.out.println("1: Press '1' for Tools.");
            System.out.println("2: Press '2' for News.");
            System.out.println("3: Press '3' for Blogs.");
            System.out.println("99: Press '99' to quit.");
            System.out.println("");
            Scanner reader = new Scanner(System.in); // Reading from System.in
            System.out.println("Please make a selection: ");
            int n = reader.nextInt();

            switch (n) {
                case 1:
                    System.out.println("You chose Tools.");
                    launch(tools);
                    continue;
                case 2:
                    System.out.println("You chose News.");
                    launch(news);
                    continue;
                case 3:
                    System.out.println("You chose Blogs.");
                    launch(blogs);
                    continue;
                case 99:
                    System.out.println("You chose Quit.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    continue;
            }
            reader.close();
        }
    }

    public static void launch(String[] listx) {
        for (String strTemp : listx) {
            try {
                Process p = Runtime.getRuntime().exec(
                        new String[] { "\"C:/Program Files (x86)/Google/Chrome/Application/chrome.exe\"", strTemp });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}