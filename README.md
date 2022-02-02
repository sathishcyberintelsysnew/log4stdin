# log4stdin &mdash; log4shell injection for anything with stdout

This repository contains a Java application intentionally vulnerable to CVE-2021-44228, colloquially known as log4shell.

log4stdin is quite literally nothing more than an stdin-reader, input of which is fed into a vulnerable log4j instance. The project uses Maven artefacts log4j-api 2.14.1 and log4j-core 2.14.1.


## How to use?

Use Unix pipes for input. For example to subject log entries to an injectability treatment, run 

```cat output.log | java -jar log4stdin.jar```

Alternatively, for real time log reading, run

```tail -f output.log | java -jar log4stdin.jar```

log4stdin prints whatever is fed to stdin but does nothing to handle user input. Therefore it is suitable for reading log files, as exemplified above, or to be used with software requiring no user interaction.

The contents of this repository are bound to be classified either as infected files or attempts of issuing malicious commands by AVs. It might be a good idea to exclude the target folder from AV scanning before cloning the repository. It might be an even better idea to try it out in a virtual environment with no network connections.


## What for?

Firsly, it may be used to explore the consequence of having a JNDI injection point practically anywhere, without the need to fork any existing pieces of software. It may be useful in  researching or testing protection methods.

Secondly, it is basically the "Hello World" of cybersec, written to underline both the simplicity and the severity of the vulnerability.

Thirdly, it may be used to test if an AV solution is able to detect software exploiting CVE-2021-44228. log4stdin.java or log4stdin.jar might be flagged as Generic.Zojfor.G, for example.


## It's on you

Anyway, whatever you decide to use this for makes you accountable for any consequences.


## Licenses

### log4stdin

MIT license. Read more in LICENSE.md.

It's not like there was much heavy lifting to do though, and feel free to reproduce the thing on your own accord, and no-one's going to come chasing after you.


### Apache Log4j2

Copyright 1999&ndash;2021 The Apache Software Foundation

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
