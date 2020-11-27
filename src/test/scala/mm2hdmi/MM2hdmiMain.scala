// See README.md for license details.

package mm2hdmi

import chisel3._

/**
  * This provides an alternate way to run tests, by executing then as a main
  * From sbt (Note: the test: prefix is because this main is under the test package hierarchy):
  * {{{
  * test:runMain mm2hdmi.MM2hdmiMain
  * }}}
  * To see all command line options use:
  * {{{
  * test:runMain mm2hdmi.MM2hdmiMain --help
  * }}}
  * To run with verilator:
  * {{{
  * test:runMain mm2hdmi.MM2hdmiMain --backend-name verilator
  * }}}
  * To run with verilator from your terminal shell use:
  * {{{
  * sbt 'test:runMain mm2hdmi.MM2hdmiMain --backend-name verilator'
  * }}}
  */
object MM2hdmiMain extends App {
  iotesters.Driver.execute(args, () => new MM2hdmi) {
    c => new MM2hdmiUnitTester(c)
  }
}

/**
  * This provides a way to run the firrtl-interpreter REPL (or shell)
  * on the lowered firrtl generated by your circuit. You will be placed
  * in an interactive shell. This can be very helpful as a debugging
  * technique. Type help to see a list of commands.
  *
  * To run from sbt
  * {{{
  * test:runMain mm2hdmi.MM2hdmiRepl
  * }}}
  * To run from sbt and see the half a zillion options try
  * {{{
  * test:runMain mm2hdmi.MM2hdmiRepl --help
  * }}}
  */
object MM2hdmiRepl extends App {
  iotesters.Driver.executeFirrtlRepl(args, () => new MM2hdmi)
}