<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="html" indent="yes">

    </xsl:output>
<xsl:output method="html" indent="yes">

</xsl:output>
    <xsl:template match="/ReviewApplication">
        <html>
        <body>
         <h1>username5 Recommendations</h1>
        <table border="2">
            <tr>
                <th>UserName</th>
                <th>Recommendations</th>
            </tr>
            <xsl:for-each select="Users/User[UserName/text()='username5']">
                    <xsl:variable name="uname" select="UserName">

                    </xsl:variable>
                    <tr>
                        <td>
                            <xsl:value-of select="UserName">

                            </xsl:value-of>
                        </td>
                        <td>
                            <xsl:value-of select="../../Recommendations/count(
                            Recommendation[UserName/text()=$uname]
                            )">

                            </xsl:value-of>
                        </td>
                    </tr>
            </xsl:for-each>
        </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>