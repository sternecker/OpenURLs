// The script assumes you are running Firefox.
// The script presents an options menu and opens browser tabs based on selection.

package main

import (
	"bufio"
	"fmt"
	"os"
	"os/exec"
)

func launch(list ...string) {
	chrome := "firefox"

	for _, element := range list {
		cmd := exec.Command(chrome, "--chrome-frame", "%s", element)
		err := cmd.Start()
		if err != nil {
			println("Failed to start chrome:", err)
		}
	}
	return
}

func main() {
	valid := true
	for valid {

		// Education Sites
		education := []string{
			"https://www.pluralsight.com",
			"https://www.masterclass.com"}

		//Tools sites
		tools := []string{
			"https://urlscan.io/",
			"https://www.virustotal.com/",
			"https://www.hybrid-analysis.com/",
			"https://www.google.com/transparencyreport/safebrowsing/diagnostic/",
			"https://www.ssllabs.com/",
			"https://mxtoolbox.com/",
			"http://toolbar.netcraft.com/site_report"}

		// News related sites
		news := []string{
			"https://www.bellingcat.com/",
			"https://www.darkreading.com/",
			"https://www.fifthdomain.com/?source=dfn-nav",
			"https://isc.sans.edu/"}

		// Various Blogs
		blogs := []string{
			"https://krebsonsecurity.com/",
			"https://www.schneier.com/",
			"https://blogs.gartner.com/blog/category/security/"}

		// clear the screen linux version
		c := exec.Command("clear")
		c.Stdout = os.Stdout
		c.Run()

		println("================ Infosec Menu ================")
		println("1: Press '1' for Tools.")
		println("2: Press '2' for News.")
		println("3: Press '3' for Blogs.")
		println("4: Press '4' for Education.")
		println("Q: Press 'Q' to quit.")
		println("")
		println("Please make a selection: ")
		reader := bufio.NewReader(os.Stdin)
		char, _, err := reader.ReadRune()

		if err != nil {
			fmt.Println(err)
		}

		switch char {
		case '1':
			c.Run()
			fmt.Println("You chose Tools.")
			launch(tools...)
		case '2':
			c.Run()
			fmt.Println("You chose News.")
			launch(news...)
		case '3':
			c.Run()
			fmt.Println("You chose Blogs")
			launch(blogs...)
		case '4':
			c.Run()
			fmt.Println("You chose Education")
			launch(education...)
		case 'q':
			valid = false
			break
		}
	}
}
