
create table ACTIVITIES
(
  ACTIVITIESID VARCHAR2(100) not null,
  TITLE        VARCHAR2(100) default '',
  CONTENTS     VARCHAR2(100) default '',
  ADDTIME      VARCHAR2(100) default '',
  HITS         VARCHAR2(100) default '',
  NUM          VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ACTIVITIES
  add primary key (ACTIVITIESID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table ADMIN
(
  ADMINID  VARCHAR2(100) not null,
  USERNAME VARCHAR2(100) default '',
  PASSWORD VARCHAR2(100) default '',
  REALNAME VARCHAR2(100) default '',
  CONTACT  VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ADMIN
  add primary key (ADMINID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table CATE
(
  CATEID   VARCHAR2(100) not null,
  CATENAME VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table CATE
  add primary key (CATEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table PET
(
  PETID    VARCHAR2(100) not null,
  PNO      VARCHAR2(100) default '',
  PETNAME  VARCHAR2(100) default '',
  IMAGE    VARCHAR2(100) default '',
  CATEID   VARCHAR2(100) default '',
  ADDTIME  VARCHAR2(100) default '',
  HITS     VARCHAR2(100) default '',
  STATUS   VARCHAR2(100) default '',
  CONTENTS VARCHAR2(2000) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PET
  add primary key (PETID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table PET
  add constraint FK1B11F96D32A57 foreign key (CATEID)
  references CATE (CATEID);

create table USERS
(
  USERSID  VARCHAR2(100) not null,
  USERNAME VARCHAR2(100) default '',
  PASSWORD VARCHAR2(100) default '',
  REALNAME VARCHAR2(100) default '',
  SEX      VARCHAR2(100) default '',
  BIRTHDAY VARCHAR2(100) default '',
  IDCARD   VARCHAR2(100) default '',
  CONTACT  VARCHAR2(100) default '',
  IMAGE    VARCHAR2(100) default '',
  REGDATE  VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table USERS
  add primary key (USERSID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table APPLYS
(
  APPLYSID VARCHAR2(100) not null,
  USERSID  VARCHAR2(100) default '',
  PETID    VARCHAR2(100) default '',
  ADDTIME  VARCHAR2(100) default '',
  STATUS   VARCHAR2(100) default '',
  MEMO     VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table APPLYS
  add primary key (APPLYSID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table APPLYS
  add constraint FKABE4EAC51AB1D48D foreign key (USERSID)
  references USERS (USERSID);
alter table APPLYS
  add constraint FKABE4EAC57933A17B foreign key (PETID)
  references PET (PETID);

create table ARTICLE
(
  ARTICLEID VARCHAR2(100) not null,
  TITLE     VARCHAR2(100) default '',
  IMAGE     VARCHAR2(100) default '',
  CONTENTS  VARCHAR2(100) default '',
  ADDTIME   VARCHAR2(100) default '',
  HITS      VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ARTICLE
  add primary key (ARTICLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table ASIGN
(
  ASIGNID      VARCHAR2(100) not null,
  USERSID      VARCHAR2(100) default '',
  ACTIVITIESID VARCHAR2(100) default '',
  ADDTIME      VARCHAR2(100) default '',
  MEMO         VARCHAR2(100) default '',
  STATUS       VARCHAR2(50 CHAR)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ASIGN
  add primary key (ASIGNID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table ASIGN
  add constraint FK58CC59E15C23D93 foreign key (ACTIVITIESID)
  references ACTIVITIES (ACTIVITIESID);
alter table ASIGN
  add constraint FK58CC59E1AB1D48D foreign key (USERSID)
  references USERS (USERSID);

create table BBS
(
  BBSID    VARCHAR2(100) not null,
  USERSID  VARCHAR2(100) default '',
  TITLE    VARCHAR2(100) default '',
  CONTENTS VARCHAR2(2000) default '',
  ADDTIME  VARCHAR2(100) default '',
  HITS     VARCHAR2(100) default '',
  REPNUM   VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BBS
  add primary key (BBSID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BBS
  add constraint FK17C331AB1D48D foreign key (USERSID)
  references USERS (USERSID);

create table REBBS
(
  REBBSID  VARCHAR2(100) not null,
  USERSID  VARCHAR2(100) default '',
  BBSID    VARCHAR2(100) default '',
  CONTENTS VARCHAR2(2000) default '',
  ADDTIME  VARCHAR2(100) default ''
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table REBBS
  add primary key (REBBSID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table REBBS
  add constraint FK675DD201AB1D48D foreign key (USERSID)
  references USERS (USERSID);


insert into ACTIVITIES (ACTIVITIESID, TITLE, CONTENTS, ADDTIME, HITS, NUM)
values ('40289f126277180c0162771b23760002', 'CKU双血统柴犬幼犬', '<p>CKU双血统柴犬幼犬CKU双血统柴犬幼犬CKU双血统柴犬幼犬</p>' || chr(13) || '' || chr(10) || '', '2018-03-30', '14', '3');
insert into ACTIVITIES (ACTIVITIESID, TITLE, CONTENTS, ADDTIME, HITS, NUM)
values ('40289f12627fe19401627fe2c8d60003', '44444444444', '<p>在此添加内容44444444</p>' || chr(13) || '' || chr(10) || '', '2018-04-01', '2', '1');
commit;
insert into ADMIN (ADMINID, USERNAME, PASSWORD, REALNAME, CONTACT)
values ('1', 'admin', 'admin', 'admin', 'admin');
commit;
insert into CATE (CATEID, CATENAME)
values ('40289f126277180c0162771b5bbc0003', '宠物狗');
insert into CATE (CATEID, CATENAME)
values ('40289f126277180c0162771b7c470004', '宠物猫');
insert into CATE (CATEID, CATENAME)
values ('40289f12627fe19401627fe420a10008', '其他动物');
commit;
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126277180c0162771c06e20005', 'CKU双血统柴犬幼犬', 'CKU双血统柴犬幼犬', 'upfiles/20180330213222.jpg', '40289f126277180c0162771b5bbc0003', '2018-03-30', '6', '已领养', '<p>在此添加内容CKU双血统柴犬幼犬</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279ada10f0001', '纯种哈士奇幼犬', '纯种哈士奇幼犬', 'upfiles/20180331093038.jpg', '40289f126277180c0162771b5bbc0003', '2018-03-31', '1', '未领养', '<p>纯种哈士奇幼犬</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279ae94620002', 'P20180331093132', '纯种威尔士柯基幼犬', 'upfiles/20180331093140.jpg', '40289f126277180c0162771b5bbc0003', '2018-03-31', '1', '未领养', '<p>纯种威尔士柯基幼犬</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279aec8150003', 'P20180331093147', '法国斗牛犬 蓝血虎斑', 'upfiles/20180331093153.jpg', '40289f126277180c0162771b5bbc0003', '2018-03-31', '0', '未领养', '<p>法国斗牛犬 蓝血虎斑</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279b048190004', 'P20180331093323', '日系小柴犬', 'upfiles/20180331093334.jpg', '40289f126277180c0162771b5bbc0003', '2018-03-31', '0', '未领养', '<p>日系小柴犬</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279b0a0280005', 'P20180331093338', '白加菲弟弟', 'upfiles/20180331093348.jpg', '40289f126277180c0162771b7c470004', '2018-03-31', '0', '未领养', '<p>白加菲弟弟</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f126279ab38016279b14cbe0006', 'P20180331093401', '蓝山猫双色绅士', 'upfiles/20180331093427.jpg', '40289f126277180c0162771b7c470004', '2018-03-31', '2', '已领养', '<p>蓝山猫双色绅士</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f12627fe19401627fe49fa80009', 'P20180401142810', '变色树蜥', 'upfiles/20180401142827.jpg', '40289f12627fe19401627fe420a10008', '2018-04-01', '0', '未领养', '<p>变色树蜥</p>' || chr(13) || '' || chr(10) || '');
insert into PET (PETID, PNO, PETNAME, IMAGE, CATEID, ADDTIME, HITS, STATUS, CONTENTS)
values ('40289f12627fe19401627fe4f752000a', 'P20180401142841', '丽纹龙蜥', 'upfiles/20180401142850.jpg', '40289f12627fe19401627fe420a10008', '2018-04-01', '0', '未领养', '<p>丽纹龙蜥</p>' || chr(13) || '' || chr(10) || '');
commit;

insert into USERS (USERSID, USERNAME, PASSWORD, REALNAME, SEX, BIRTHDAY, IDCARD, CONTACT, IMAGE, REGDATE)
values ('40289f12627cd05201627ce1e6890001', '123123', '123123', '123123', '男', '2018-04-01', '123123', '123123', 'upfiles/20180401002640.jpg', '2018-04-01');
insert into USERS (USERSID, USERNAME, PASSWORD, REALNAME, SEX, BIRTHDAY, IDCARD, CONTACT, IMAGE, REGDATE)
values ('40289f12627fe19401627fe32e250004', '333', '333', '333', '男', '2018-04-01', '333', '333', 'upfiles/20180401142655.jpg', '2018-04-01');
commit;

insert into APPLYS (APPLYSID, USERSID, PETID, ADDTIME, STATUS, MEMO)
values ('40289f12627f530801627f57085e0001', '40289f12627cd05201627ce1e6890001', '40289f126277180c0162771c06e20005', '2018-04-01', '同意', '123123');
insert into APPLYS (APPLYSID, USERSID, PETID, ADDTIME, STATUS, MEMO)
values ('40289f12627fe19401627fe551f0000b', '40289f12627fe19401627fe32e250004', '40289f126279ab38016279ada10f0001', '2018-04-01', '拒绝', '从V字形从V字形从v');
insert into APPLYS (APPLYSID, USERSID, PETID, ADDTIME, STATUS, MEMO)
values ('40289f12627fe19401627fe570d2000c', '40289f12627fe19401627fe32e250004', '40289f126279ab38016279b14cbe0006', '2018-04-01', '同意', '自行车V字形从v');
commit;

insert into ARTICLE (ARTICLEID, TITLE, IMAGE, CONTENTS, ADDTIME, HITS)
values ('40289f126277180c0162771b00fa0001', '111', 'upfiles/20180330213117.jpg', '<p>CKU双血统柴犬幼犬CKU双血统柴犬幼犬CKU双血统柴犬幼犬</p>' || chr(13) || '' || chr(10) || '', '2018-03-30', '1');
insert into ARTICLE (ARTICLEID, TITLE, IMAGE, CONTENTS, ADDTIME, HITS)
values ('40289f12627fe19401627fe288dc0002', '22222', 'upfiles/20180401142612.jpg', '<p>在此添加内容222222222</p>' || chr(13) || '' || chr(10) || '', '2018-04-01', '1');
commit;

insert into ASIGN (ASIGNID, USERSID, ACTIVITIESID, ADDTIME, MEMO, STATUS)
values ('40289f12627d6f1e01627f34ca680001', '40289f12627cd05201627ce1e6890001', '40289f126277180c0162771b23760002', '2018-04-01', null, '同意');
insert into ASIGN (ASIGNID, USERSID, ACTIVITIESID, ADDTIME, MEMO, STATUS)
values ('40289f12627fe19401627fe3b1210007', '40289f12627fe19401627fe32e250004', '40289f12627fe19401627fe2c8d60003', '2018-04-01', null, '未审核');
commit;

insert into BBS (BBSID, USERSID, TITLE, CONTENTS, ADDTIME, HITS, REPNUM)
values ('40289f12627cd05201627d1d0bf80002', '40289f12627cd05201627ce1e6890001', '123123', '<p>在此添加内容123123</p>' || chr(13) || '' || chr(10) || '', '2018-04-01', '4', '1');
insert into BBS (BBSID, USERSID, TITLE, CONTENTS, ADDTIME, HITS, REPNUM)
values ('40289f12627fe19401627fe3551c0005', '40289f12627fe19401627fe32e250004', '3333333', '<p>在此添加内容3333333333</p>' || chr(13) || '' || chr(10) || '', '2018-04-01', '0', '0');
commit;

insert into REBBS (REBBSID, USERSID, BBSID, CONTENTS, ADDTIME)
values ('40289f12627fe19401627fe36f630006', '40289f12627fe19401627fe32e250004', '40289f12627cd05201627d1d0bf80002', '<p>在此添加内容44444444444</p>' || chr(13) || '' || chr(10) || '', '2018-04-01');
commit;
