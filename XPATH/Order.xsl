<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
				<h1> Order Information </h1>
				<xsl:apply-templates/>				<!--  select="/Order/Item[@id='X']"  if we want to choose one -->
			
			<br/>
			<br/>
			<b>Total number of items within this order: </b>
			<xsl:value-of select="count(/Order/Item)"/>
			
			<br/>
			<br/>
			<b>Total price of items within this order: </b>
			<xsl:value-of select="sum(/Order/Item/Price)"/>
			
			</body>
		</html>
	</xsl:template>


	<xsl:template match="CustomerName">
		<b>
			Customer Name:
			<xsl:value-of select="." />
		</b>
	</xsl:template>

	<xsl:template match="Item">
		<br />
		Order Id:
		<xsl:value-of select="../@id" />

		<br />
		Item Name:
	
		<xsl:value-of select="./ItemName"/>
		
		<br />
		Price:
		<xsl:value-of select="round(./Price)" />
		
		<xsl:if test="Price &gt; 100">
		(Not eligible for free shipping)
		</xsl:if>
		
		<xsl:if test="Price &lt; 100">
		(Not eligible for free shipping)
		</xsl:if>
		
	</xsl:template>


</xsl:stylesheet>