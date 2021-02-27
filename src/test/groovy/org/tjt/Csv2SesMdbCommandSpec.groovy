package org.tjt

import io.micronaut.configuration.picocli.PicocliRunner
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment

import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Csv2SesMdbCommandSpec extends Specification {

    @Shared @AutoCleanup ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)

    void "test csv2SesMdb with command line option"() {
        given:
        ByteArrayOutputStream baos = new ByteArrayOutputStream()
        System.setOut(new PrintStream(baos))

        String[] args = ['-v'] as String[]
        PicocliRunner.run(Csv2SesMdbCommand, ctx, args)

        expect:
        baos.toString().contains('Hi!')
    }
}

