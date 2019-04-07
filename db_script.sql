USE [daw_g10]
GO
/****** Object:  Table [dbo].[AllowedLabels]    Script Date: 26/03/2019 19:01:17 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AllowedLabels](
	[project_id] [int] NOT NULL,
	[label_id] [int] NOT NULL,
 CONSTRAINT [PK_AllowedLabels] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC,
	[label_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Assoc_Issue_Label]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Assoc_Issue_Label](
	[label_id] [int] NOT NULL,
	[issue_number] [int] NOT NULL,
 CONSTRAINT [PK_Assoc_Issue_Label] PRIMARY KEY CLUSTERED 
(
	[label_id] ASC,
	[issue_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Comments]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[short_text] [varchar](100) NOT NULL,
	[issue_id] [int] NOT NULL,
 CONSTRAINT [PK_Comments] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Issues]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Issues](
	[number] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[short_desc] [varchar](500) NOT NULL,
	[creation_date] [date] NOT NULL,
	[close_date] [date] NULL,
	[state_id] [int] NOT NULL,
	[project_id] [int] NOT NULL,
 CONSTRAINT [PK_Issues] PRIMARY KEY CLUSTERED 
(
	[number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Labels]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Labels](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Labels] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Projects]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Projects](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[short_desc] [varchar](200) NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_Projects] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[States]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[States](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[project_id] [int] NOT NULL,
 CONSTRAINT [PK_States] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Transitions]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transitions](
	[project_id] [int] NOT NULL,
	[initial_state_id] [int] NOT NULL,
	[target_state_id] [int] NOT NULL,
 CONSTRAINT [PK_Transitions] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC,
	[initial_state_id] ASC,
	[target_state_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Users]    Script Date: 26/03/2019 19:01:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[password] [varchar](40) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[AllowedLabels]  WITH CHECK ADD  CONSTRAINT [FK_AllowedLabels_Labels] FOREIGN KEY([label_id])
REFERENCES [dbo].[Labels] ([id])
GO
ALTER TABLE [dbo].[AllowedLabels] CHECK CONSTRAINT [FK_AllowedLabels_Labels]
GO
ALTER TABLE [dbo].[AllowedLabels]  WITH CHECK ADD  CONSTRAINT [FK_AllowedLabels_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])
GO
ALTER TABLE [dbo].[AllowedLabels] CHECK CONSTRAINT [FK_AllowedLabels_Projects]
GO
ALTER TABLE [dbo].[Assoc_Issue_Label]  WITH CHECK ADD  CONSTRAINT [FK_Assoc_Issue_Label_Issues] FOREIGN KEY([issue_number])
REFERENCES [dbo].[Issues] ([number])
GO
ALTER TABLE [dbo].[Assoc_Issue_Label] CHECK CONSTRAINT [FK_Assoc_Issue_Label_Issues]
GO
ALTER TABLE [dbo].[Assoc_Issue_Label]  WITH CHECK ADD  CONSTRAINT [FK_Assoc_Issue_Label_Labels] FOREIGN KEY([label_id])
REFERENCES [dbo].[Labels] ([id])
GO
ALTER TABLE [dbo].[Assoc_Issue_Label] CHECK CONSTRAINT [FK_Assoc_Issue_Label_Labels]
GO
ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [FK_Comments_Issues] FOREIGN KEY([issue_id])
REFERENCES [dbo].[Issues] ([number])
GO
ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [FK_Comments_Issues]
GO
ALTER TABLE [dbo].[Issues]  WITH CHECK ADD  CONSTRAINT [FK_Issues_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])
GO
ALTER TABLE [dbo].[Issues] CHECK CONSTRAINT [FK_Issues_Projects]
GO
ALTER TABLE [dbo].[Issues]  WITH CHECK ADD  CONSTRAINT [FK_Issues_States] FOREIGN KEY([state_id])
REFERENCES [dbo].[States] ([id])
GO
ALTER TABLE [dbo].[Issues] CHECK CONSTRAINT [FK_Issues_States]
GO
ALTER TABLE [dbo].[Projects]  WITH CHECK ADD  CONSTRAINT [FK_Projects_Users] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])
GO
ALTER TABLE [dbo].[Projects] CHECK CONSTRAINT [FK_Projects_Users]
GO
ALTER TABLE [dbo].[States]  WITH CHECK ADD  CONSTRAINT [FK_States_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])
GO
ALTER TABLE [dbo].[States] CHECK CONSTRAINT [FK_States_Projects]
GO
ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])
GO
ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_Projects]
GO
ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_States] FOREIGN KEY([initial_state_id])
REFERENCES [dbo].[States] ([id])
GO
ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_States]
GO
ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_States1] FOREIGN KEY([target_state_id])
REFERENCES [dbo].[States] ([id])
GO
ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_States1]
GO
