<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

	<xsl:template match="/">
		<html>
			<body>
				<h1>Event Information:</h1>
				<b>
					Number of Participants:
					<xsl:value-of
						select="count(/event/participants/participant)" />
				</b>
				<div>
					Id:
					<xsl:value-of select="event/@id" />
				</div>
				<xsl:apply-templates />
			</body>
		</html>
	</xsl:template>
	<xsl:template match="id">

		<div>
			Id:
			<xsl:value-of select="." />
		</div>
	</xsl:template>
	<xsl:template match="name">
		<div>
			Name:
			<xsl:value-of select="." />

		</div>

	</xsl:template>
	<xsl:template match="description">
		<div>
			Description:
			<xsl:value-of select="." />

		</div>

	</xsl:template>
	<xsl:template match="price">

		<div>
			Price:
			<xsl:value-of select="." />

		</div>

	</xsl:template>

	<xsl:template match="startTime">
		<div>
			Start Time:
			<xsl:value-of select="." />
		</div>
	</xsl:template>
	<xsl:template match="endTime">
		<div>
			End Time:
			<xsl:value-of select="." />

		</div>

	</xsl:template>
	<xsl:template match="organizer">

		<h1>Organizer Info:</h1>
		<div>
			Id:
			<xsl:value-of select="id" />

		</div>
		<div>
			Name:
			<xsl:value-of select="name" />

		</div>
		<div>
			Email:
			<xsl:value-of select="email" />

		</div>
		<div>
			Phone Number:
			<xsl:value-of select="phoneNumber" />

		</div>

	</xsl:template>
	<xsl:template match="venue">

		<h1>Venue Info:</h1>
		<div>
			Id:
			<xsl:value-of select="id" />

		</div>
		<div>
			Name:
			<xsl:value-of select="name" />

		</div>
		<div>
			Street:
			<xsl:value-of select="street" />

		</div>
		<div>
			City:
			<xsl:value-of select="city" />

		</div>

	</xsl:template>
	<xsl:template match="participants">

		<h1>Participants:</h1>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Phone</th>
			</tr>
			<xsl:for-each select="participant">

				<xsl:sort select="name" order="descending" />
				<tr>
					<td>
						<xsl:value-of select="id" />
					</td>
					<td>
						<xsl:value-of select="name" />
					</td>
					<td>

						<xsl:value-of select="email" />
					</td>
					<td>

						<xsl:value-of select="phoneNumber" />
					</td>
				</tr>

			</xsl:for-each>

		</table>

	</xsl:template>

</xsl:stylesheet>