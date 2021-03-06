USE [master]
GO
/****** Object:  Database [managerStudent]    Script Date: 08/12/2021 1:56:09 CH ******/
CREATE DATABASE [managerStudent] 
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [managerStudent].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [managerStudent] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [managerStudent] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [managerStudent] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [managerStudent] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [managerStudent] SET ARITHABORT OFF 
GO
ALTER DATABASE [managerStudent] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [managerStudent] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [managerStudent] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [managerStudent] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [managerStudent] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [managerStudent] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [managerStudent] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [managerStudent] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [managerStudent] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [managerStudent] SET  DISABLE_BROKER 
GO
ALTER DATABASE [managerStudent] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [managerStudent] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [managerStudent] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [managerStudent] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [managerStudent] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [managerStudent] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [managerStudent] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [managerStudent] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [managerStudent] SET  MULTI_USER 
GO
ALTER DATABASE [managerStudent] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [managerStudent] SET DB_CHAINING OFF 
GO
ALTER DATABASE [managerStudent] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [managerStudent] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [managerStudent] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [managerStudent] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [managerStudent] SET QUERY_STORE = OFF
GO
USE [managerStudent]
GO
/****** Object:  Table [dbo].[student]    Script Date: 08/12/2021 1:56:10 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[student](
	[ID] [varchar](5) NOT NULL,
	[name] [nvarchar](50) NULL,
	[GPA] [float] NULL,
	[Image] [nvarchar](100) NULL,
	[Address] [nvarchar](100) NULL,
	[Note] [nvarchar](100) NULL
) ON [PRIMARY]
GO
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'1', N'Tran Thi Buoi', 2.6, N'abc', N'Le Van Luong', N'none')
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'2', N'Nguyen Van B', 3.5, N'abc', N'Nguyen Van Linh', N'none')
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'112', N'Tran Van Do', 2.4, N'abc', N'Nguyen Van Cu, Quan 5, Tp HCM', N'none')
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'123', N'Nguyen DO', 3.4, N'sdasd', N'Hoang Quoc Viet, Quan 8, Tp HCM', N'sdas')
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'456', N'Nguyen Van A', 2.4, N'dsadas', N'Nguyen Tat Thanh, Quan 1', N'weq')
INSERT [dbo].[student] ([ID], [name], [GPA], [Image], [Address], [Note]) VALUES (N'789', N'Nguyen Van C', 2.1, N'cdf', N'Tran Hung Dao', N'none')
GO
USE [master]
GO
ALTER DATABASE [managerStudent] SET  READ_WRITE 
GO
