/****** Object:  Table [dbo].[Assoc_Issue_Label]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

CREATE TABLE [dbo].[Assoc_Issue_Label](
    [label_id] [int] NOT NULL,
    [issue_number] [int] NOT NULL,
 CONSTRAINT [PK_Assoc_Issue_Label] PRIMARY KEY CLUSTERED 
(
    [label_id] ASC,
    [issue_number] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


/****** Object:  Table [dbo].[Comments]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[Comments](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [short_text] [varchar](100) NOT NULL,
    [issue_id] [int] NOT NULL,
 CONSTRAINT [PK_Comments] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[Issues]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

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


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[Labels]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[Labels](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [project_id] [int] NOT NULL,
    [name] [varchar](30) NOT NULL,
 CONSTRAINT [PK_Labels_1] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[Projects]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

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


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[States]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[States](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [name] [varchar](20) NOT NULL,
    [project_id] [int] NOT NULL,
 CONSTRAINT [PK_States] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

/****** Object:  Table [dbo].[Transitions]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

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


/****** Object:  Table [dbo].[Users]    Script Date: 15/05/2019 20:52:40 ******/
SET ANSI_NULLS ON

SET QUOTED_IDENTIFIER ON

SET ANSI_PADDING ON

CREATE TABLE [dbo].[Users](
    [id] [int] IDENTITY(1,1) NOT NULL,
    [username] [varchar](20) NOT NULL,
    [password] [varchar](40) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
    [id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


SET ANSI_PADDING OFF

ALTER TABLE [dbo].[Assoc_Issue_Label]  WITH CHECK ADD  CONSTRAINT [FK_Assoc_Issue_Label_Issues] FOREIGN KEY([issue_number])
REFERENCES [dbo].[Issues] ([number])

ALTER TABLE [dbo].[Assoc_Issue_Label] CHECK CONSTRAINT [FK_Assoc_Issue_Label_Issues]

ALTER TABLE [dbo].[Assoc_Issue_Label]  WITH CHECK ADD  CONSTRAINT [FK_Assoc_Issue_Label_Labels1] FOREIGN KEY([label_id])
REFERENCES [dbo].[Labels] ([id])

ALTER TABLE [dbo].[Assoc_Issue_Label] CHECK CONSTRAINT [FK_Assoc_Issue_Label_Labels1]

ALTER TABLE [dbo].[Comments]  WITH CHECK ADD  CONSTRAINT [FK_Comments_Issues] FOREIGN KEY([issue_id])
REFERENCES [dbo].[Issues] ([number])

ALTER TABLE [dbo].[Comments] CHECK CONSTRAINT [FK_Comments_Issues]

ALTER TABLE [dbo].[Issues]  WITH CHECK ADD  CONSTRAINT [FK_Issues_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])

ALTER TABLE [dbo].[Issues] CHECK CONSTRAINT [FK_Issues_Projects]

ALTER TABLE [dbo].[Issues]  WITH CHECK ADD  CONSTRAINT [FK_Issues_States] FOREIGN KEY([state_id])
REFERENCES [dbo].[States] ([id])

ALTER TABLE [dbo].[Issues] CHECK CONSTRAINT [FK_Issues_States]

ALTER TABLE [dbo].[Labels]  WITH CHECK ADD  CONSTRAINT [FK_Labels_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])

ALTER TABLE [dbo].[Labels] CHECK CONSTRAINT [FK_Labels_Projects]

ALTER TABLE [dbo].[Projects]  WITH CHECK ADD  CONSTRAINT [FK_Projects_Users] FOREIGN KEY([user_id])
REFERENCES [dbo].[Users] ([id])

ALTER TABLE [dbo].[Projects] CHECK CONSTRAINT [FK_Projects_Users]

ALTER TABLE [dbo].[States]  WITH CHECK ADD  CONSTRAINT [FK_States_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])

ALTER TABLE [dbo].[States] CHECK CONSTRAINT [FK_States_Projects]

ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_Projects] FOREIGN KEY([project_id])
REFERENCES [dbo].[Projects] ([id])

ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_Projects]

ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_States] FOREIGN KEY([initial_state_id])
REFERENCES [dbo].[States] ([id])

ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_States]

ALTER TABLE [dbo].[Transitions]  WITH CHECK ADD  CONSTRAINT [FK_Transitions_States1] FOREIGN KEY([target_state_id])
REFERENCES [dbo].[States] ([id])

ALTER TABLE [dbo].[Transitions] CHECK CONSTRAINT [FK_Transitions_States1]