import sys.process._
import java.io.File

val base_folder = "/home/user/myrepos/"
val base_url = "https://github.com/mycompany/"

case class PullRequest(repository: String, pullRequests: Seq[String])

@main def pull_requests: Unit =
  pretty_print(get_pull_requests(get_directories()))

def get_directories(): Seq[String] = Process("ls", new File(base_folder)).!!.split("\n").toSeq

def get_pull_requests(input: Seq[String]): Seq[PullRequest] = input.map(s => { PullRequest(s, Process("gh pr list", new File(base_folder + s)).!!.split("\n").toSeq)}).toSeq

def pretty_print(input: Seq[PullRequest]): Unit =
  input.foreach(p =>
    if(!p._2.apply(0).equals(""))
      println(p._1.toUpperCase())
      p._2.foreach(e =>
        if(e.charAt(2).equals(" "))
          val a = e.substring(2).trim
          println(a.substring(0, a.length-4) + "View this pull request on GitHub.com: " + base_url + p._1 + "/pull/" + e.substring(0,2))
        else
          val a = e.substring(3).trim
          println(a.substring(0, a.length-4) + "View this pull request on GitHub.com: " + base_url + p._1 + "/pull/" + e.substring(0,3))
      )
      println(""))