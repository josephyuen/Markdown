package com.nzf.markdown.video.entity;

import java.util.List;

/**
 * Created by joseph on 2017/12/1.
 */

public class NotesBean {

    private int id;
    private String content;
    private int sectionId;
    private int creator;
    private String gmtCreate;
    private long gmtCreateStamp;
    private int isHavePraise;
    private int isHaveTread;
    private int isHaveCollect;
    private String gmtCreateStr;
    private NoteDynamicBean noteDynamic;
    private CreatorDetailBean creatorDetail;
    private int concernStatus;
    private int courseId;
    private List<NoteAttachesBean> noteAttaches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public long getGmtCreateStamp() {
        return gmtCreateStamp;
    }

    public void setGmtCreateStamp(long gmtCreateStamp) {
        this.gmtCreateStamp = gmtCreateStamp;
    }

    public int getIsHavePraise() {
        return isHavePraise;
    }

    public void setIsHavePraise(int isHavePraise) {
        this.isHavePraise = isHavePraise;
    }

    public int getIsHaveTread() {
        return isHaveTread;
    }

    public void setIsHaveTread(int isHaveTread) {
        this.isHaveTread = isHaveTread;
    }

    public int getIsHaveCollect() {
        return isHaveCollect;
    }

    public void setIsHaveCollect(int isHaveCollect) {
        this.isHaveCollect = isHaveCollect;
    }

    public String getGmtCreateStr() {
        return gmtCreateStr;
    }

    public void setGmtCreateStr(String gmtCreateStr) {
        this.gmtCreateStr = gmtCreateStr;
    }

    public NoteDynamicBean getNoteDynamic() {
        return noteDynamic;
    }

    public void setNoteDynamic(NoteDynamicBean noteDynamic) {
        this.noteDynamic = noteDynamic;
    }

    public CreatorDetailBean getCreatorDetail() {
        return creatorDetail;
    }

    public void setCreatorDetail(CreatorDetailBean creatorDetail) {
        this.creatorDetail = creatorDetail;
    }

    public int getConcernStatus() {
        return concernStatus;
    }

    public void setConcernStatus(int concernStatus) {
        this.concernStatus = concernStatus;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<NoteAttachesBean> getNoteAttaches() {
        return noteAttaches;
    }

    public void setNoteAttaches(List<NoteAttachesBean> noteAttaches) {
        this.noteAttaches = noteAttaches;
    }

    public static class NoteDynamicBean {
        /**
         * attachCount : 5
         * picCount : 5
         * videoCount : 0
         * clickCount : 22
         * replyCount : 6
         * praiseCount : 13
         * treadCount : 0
         * sharedCount : 0
         * tipoffCount : 0
         */

        private int attachCount;
        private int picCount;
        private int videoCount;
        private int clickCount;
        private int replyCount;
        private int praiseCount;
        private int treadCount;
        private int sharedCount;
        private int tipoffCount;

        public int getAttachCount() {
            return attachCount;
        }

        public void setAttachCount(int attachCount) {
            this.attachCount = attachCount;
        }

        public int getPicCount() {
            return picCount;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public int getVideoCount() {
            return videoCount;
        }

        public void setVideoCount(int videoCount) {
            this.videoCount = videoCount;
        }

        public int getClickCount() {
            return clickCount;
        }

        public void setClickCount(int clickCount) {
            this.clickCount = clickCount;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public int getPraiseCount() {
            return praiseCount;
        }

        public void setPraiseCount(int praiseCount) {
            this.praiseCount = praiseCount;
        }

        public int getTreadCount() {
            return treadCount;
        }

        public void setTreadCount(int treadCount) {
            this.treadCount = treadCount;
        }

        public int getSharedCount() {
            return sharedCount;
        }

        public void setSharedCount(int sharedCount) {
            this.sharedCount = sharedCount;
        }

        public int getTipoffCount() {
            return tipoffCount;
        }

        public void setTipoffCount(int tipoffCount) {
            this.tipoffCount = tipoffCount;
        }
    }

    public static class CreatorDetailBean {
        /**
         * uid : 3256
         * userIcon : https://rescdn.yishihui.com/ysh/pic/users/userid_3256/head/head_1487054760148.jpg
         * userNick : 名侦探老赵
         * honor : 1
         * type : 1
         * showRole : {"roleId":1,"roleName":"老师"}
         * commiteeClasses : []
         */

        private int uid;
        private String userIcon;
        private String userNick;
        private int honor;
        private int type;
        private ShowRoleBean showRole;
        private List<?> commiteeClasses;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
        }

        public String getUserNick() {
            return userNick;
        }

        public void setUserNick(String userNick) {
            this.userNick = userNick;
        }

        public int getHonor() {
            return honor;
        }

        public void setHonor(int honor) {
            this.honor = honor;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public ShowRoleBean getShowRole() {
            return showRole;
        }

        public void setShowRole(ShowRoleBean showRole) {
            this.showRole = showRole;
        }

        public List<?> getCommiteeClasses() {
            return commiteeClasses;
        }

        public void setCommiteeClasses(List<?> commiteeClasses) {
            this.commiteeClasses = commiteeClasses;
        }

        public static class ShowRoleBean {
            /**
             * roleId : 1
             * roleName : 老师
             */

            private int roleId;
            private String roleName;

            public int getRoleId() {
                return roleId;
            }

            public void setRoleId(int roleId) {
                this.roleId = roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }
        }
    }

    public static class NoteAttachesBean {
        /**
         * fileType : 1
         * sort : 0
         * url : https://rescdn.yishihui.com/ysh/pic/zone/formal/noteAttach/2017-11-30/noteId_5142/attach_1512030225704.jpg
         * duration : 0
         * height : 640
         * width : 880
         * name : 39690A33-1DDF-410C
         * isHaveVoice : 0
         * isHaveCover : 0
         * attachVoices : []
         */

        private int fileType;
        private int sort;
        private String url;
        private int duration;
        private int height;
        private int width;
        private String name;
        private int isHaveVoice;
        private int isHaveCover;
        private List<?> attachVoices;

        public int getFileType() {
            return fileType;
        }

        public void setFileType(int fileType) {
            this.fileType = fileType;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIsHaveVoice() {
            return isHaveVoice;
        }

        public void setIsHaveVoice(int isHaveVoice) {
            this.isHaveVoice = isHaveVoice;
        }

        public int getIsHaveCover() {
            return isHaveCover;
        }

        public void setIsHaveCover(int isHaveCover) {
            this.isHaveCover = isHaveCover;
        }

        public List<?> getAttachVoices() {
            return attachVoices;
        }

        public void setAttachVoices(List<?> attachVoices) {
            this.attachVoices = attachVoices;
        }
    }
}