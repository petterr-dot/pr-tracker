## pr-tracker

Keep track of all open github pull requests over different repositories

### Prerequisite

Github CLI must be installed (https://github.com/cli/cli)

`curl -fsSL https://cli.github.com/packages/githubcli-archive-keyring.gpg | sudo dd of=/usr/share/keyrings/githubcli-archive-keyring.gpg`

`echo "deb [arch=$(dpkg --print-architecture) signed-by=/usr/share/keyrings/githubcli-archive-keyring.gpg] https://cli.github.com/packages stable main" | sudo tee /etc/apt/sources.list.d/github-cli.list > /dev/null`

`sudo apt update`

`sudo apt install gh`

### Usage

Before running make sure to change base_folder & base_url in Main.scala. The base folder should contain sub directories of all the repos you would like to track 

example:

`val base_folder = "/home/myuser/my-git-repos/"`

`val base_url = "https://github.com/companyname/"`

This is a normal sbt project. You can compile code with `sbt compile`, run it with `sbt run`, and `sbt console` will start a Scala 3 REPL.
