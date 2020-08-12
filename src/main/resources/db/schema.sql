create table if not exists app
(
    id               int auto_increment primary key,
    name             varchar(50)  not null,
    packageName      varchar(100) not null,
    shortCode        varchar(50)  not null,
    description      varchar(500) null,
    currentVersionId int          null,
    iosUrl           varchar(500) null,
    createTime       datetime     null,
    updateTime       datetime     null,
    constraint app_shortCode_uindex unique (shortCode)
);

create table if not exists app_version
(
    id            int auto_increment
        primary key,
    appId         int           not null,
    name          varchar(50)   not null,
    versionName   varchar(50)   not null,
    versionCode   int           not null,
    size          int           null,
    icon          text          null,
    downloadUrl   varchar(100)  not null,
    downloadCount int           null,
    changeLog     varchar(1000) null,
    createTime    datetime      null
)

