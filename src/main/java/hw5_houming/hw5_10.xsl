<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">
    <xsl:output method="html" indent="yes"></xsl:output>
<xsl:output method="html" indent="yes"></xsl:output>
    <xsl:template match="/ReviewApplication">
        <html>
        <body>
          <h1>Reviews with Details</h1>
        <table border="2">
            <tr>
                <th>RestaurantName</th>
                <th>FirstName</th>
                <th>Rating</th>
            </tr>
            <xsl:for-each select="Reviews/Review">

                    <xsl:variable name="res" select="RestaurantId">
                    </xsl:variable>
                    <xsl:variable name="uname" select="UserName">

                    </xsl:variable>
                    <tr>
                        <td>
<!--                            <xsl:value-of select="../../Companys/Company/Restaurants/Restaurant[Name/text()=$restaurant]/Name"></xsl:value-of>-->
                            <xsl:value-of select="../../Companys/Company/Restaurants/Restaurant
                            [Name/text()=$res]
                            /Name">

                            </xsl:value-of>
                        </td>
                        <td>
                            <xsl:value-of select="../../Users/User
                            [UserName/text()=$uname]
                            /FirstName">
                            </xsl:value-of>
                        </td>
                        <td>
                            <xsl:value-of select="Rating">
                            </xsl:value-of>
                        </td>
                    </tr>
            </xsl:for-each>
        </table>
        </body>
        </html>
    </xsl:template>
</xsl:stylesheet>