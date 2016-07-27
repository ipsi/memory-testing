# Purpose
This project is for testing how Java & Garden / CGroups handle memory.

Each application is a Spring Boot application, so compile with `./mvnw clean package`.

The `devourer` application is the target for running out of memory. It should be either deployed
to CF, or started with the command `run.sh`, inside a memory group limited to 256m.

The `narcoleptic` application responds to requests from `devourer`, but waits a random amount of
time to do so - this causes objects in `devourer` to live longer than they ought to, and results
in them being added to `PS Old Gen`, which is the root cause of a lot of our problems.

To create the cgroups, I did:

    sudo cgm create memory java
    sudo cgm chown memory java andrew andrew
    sudo cgm setvalue memory java memory.limit_in_bytes 268435456

And I joined it like so:

    bash
    sudo cgm movepid memory java $$

To crash the application, modify the `load_test.jmx` file (it's just XML) to point to the URL
where you have deployed the `devourer` application, make sure you've downloaded [JMeter](http://jmeter.apache.org/download_jmeter.cgi),
and then either run as a GUI app with `$JMETER_HOME/bin/jmeter`, or headless, with `$JMETER_HOME/bin/jmeter -n -t load_test.jmx`.
