package com.app.customdimen.tools

import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

object GenerateDimenTool {
    @JvmStatic
    fun main(args: Array<String>) {
        val sw400 = StringBuilder()
        //Add the tag at the beginning of xml
        val xmlStart = """<?xml version="1.0" encoding="utf-8"?>
        <resources>"""

        sw400.append(xmlStart)
        //Add content
        for (i in 0..1920) {
            // The label name after name can be customized "margin_" to change at will
            val start = "<dimen name=\"dimen_$i\">"
            val end = "dp</dimen>"
            sw400.append(start).append(i).append(end).append("\n")
        }
        //Add the xml tail tag
        sw400.append("</resources>")
        val sw400file = "./app/src/main/res/values/dimens.xml"
        writeFile(sw400file, sw400.toString())
    }

    private fun writeFile(file: String?, text: String?) {
        var out: PrintWriter? = null
        try {
            out = PrintWriter(BufferedWriter(FileWriter(file)))
            out.println(text)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        out?.close()
    }
}