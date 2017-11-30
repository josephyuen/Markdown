package com.nzf.markdown.video.entity

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Created by joseph on 2017/11/30.
 */
class Item(`in`: Parcel) : Parcelable{
    /**
     * id : 292322
     * uid : 2131
     * name :
     * title : 上世纪的
     * 美国精神
     * excerpt : 无意关心过去的伤痛与不幸，单纯的乐观与无止境的希望，专瞩意于未来，这是上世纪的美国精神。如此名义的时代精神，造就了当时繁荣背后物质、膨胀的美国。
     * lead : 本期单读音频，许知远和大家分享的是 H . S .康马杰的作品《美国精神》。也许每一个孕育于 19 世纪末 20 世纪初的美国人都无法忘却在这个处于民族、国家历史转变时期的繁荣景象。美国人用乐观的精神态度和野心勃勃的进取心将乡村发展为城市，让曾是被孤立的弱国焕然一新，推向世界舞台的中心。相似的繁荣背后，许知远表达了他对于当下中国正弥漫着的带有民族主义倾向的担忧，包容远比封闭自我更适于理解这个广阔的世界。
     * model : 3
     * position : 0
     * thumbnail : http://img.owspace.com/Public/uploads/Picture/2016-07-19/578e28619dfbe.jpg
     * create_time : 1468939309
     * update_time : 2016/07/19
     * tags : [{"name":"美国精神"},{"name":"民族主义"},{"name":"康马杰"}]
     * status : 1
     * video :
     * fm : http://img.owspace.com/F_gye187532_1468925285.0854392.mp3
     * link_url :
     * publish_time : 0
     * view : 1.2w
     * share : http://static.owspace.com/wap/292322.html
     * comment : 20
     * good : 56
     * bookmark : 0
     * show_uid : 2131
     * fm_play : http://img.owspace.com/Public/uploads/Picture/2016-07-19/578e25288e256.jpg
     * hot_comments : [{"id":"39457","pid":"0","uid":"218409","content":"我们不要陷入自我的陷阱。唯有务实才是真正的办法","post_id":"292322","update_time":"2 天前","good":"6","model":"3","to_author_name":"Sying","under_id":"0","nickname":"Dolan Yves","avatar":"http://img.owspace.com//@/avatar/2016-04-19/46efbcfbfd6809f2eb2b34ab01ee874a45"}]
     * html5 : http://static.owspace.com/wap/292322.html
     * author : 单读音频
     * tpl : 3
     * avatar : http://img.owspace.com/Public/static/avatar/3.png
     * category : TO LISTEN
     * parseXML : 1
     */

    private var id: String? = null
    private var uid: String? = null
    private var name: String? = null
    private var title: String? = null
    private var excerpt: String? = null
    private var lead: String? = null
    private var model: String? = null
    private var position: String? = null
    private var thumbnail: String? = null
    private var create_time: String? = null
    private var update_time: String? = null
    private var status: String? = null
    private var video: String? = null
    private var fm: String? = null
    private var link_url: String? = null
    private var publish_time: String? = null
    private var view: String? = null
    private var share: String? = null
    private var comment: String? = null
    private var good: String? = null
    private var bookmark: String? = null
    private var show_uid: String? = null
    private var fm_play: String? = null
    private var html5: String? = null
    private var author: String? = null
    private var tpl: Int = 0
    private var avatar: String? = null
    private var category: String? = null
    private var parseXML: Int = 0
    /**
     * name : 美国精神
     */

    private var tags: List<TagsBean>? = null
    /**
     * id : 39457
     * pid : 0
     * uid : 218409
     * content : 我们不要陷入自我的陷阱。唯有务实才是真正的办法
     * post_id : 292322
     * update_time : 2 天前
     * good : 6
     * model : 3
     * to_author_name : Sying
     * under_id : 0
     * nickname : Dolan Yves
     * avatar : http://img.owspace.com//@/avatar/2016-04-19/46efbcfbfd6809f2eb2b34ab01ee874a45
     */

    private var hot_comments: List<HotCommentsBean>? = null

    fun getId(): String? {
        return id
    }

    fun setId(id: String) {
        this.id = id
    }

    fun getUid(): String? {
        return uid
    }

    fun setUid(uid: String) {
        this.uid = uid
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getExcerpt(): String? {
        return excerpt
    }

    fun setExcerpt(excerpt: String) {
        this.excerpt = excerpt
    }

    fun getLead(): String? {
        return lead
    }

    fun setLead(lead: String) {
        this.lead = lead
    }

    fun getModel(): String? {
        return model
    }

    fun setModel(model: String) {
        this.model = model
    }

    fun getPosition(): String? {
        return position
    }

    fun setPosition(position: String) {
        this.position = position
    }

    fun getThumbnail(): String? {
        return thumbnail
    }

    fun setThumbnail(thumbnail: String) {
        this.thumbnail = thumbnail
    }

    fun getCreate_time(): String? {
        return create_time
    }

    fun setCreate_time(create_time: String) {
        this.create_time = create_time
    }

    fun getUpdate_time(): String? {
        return update_time
    }

    fun setUpdate_time(update_time: String) {
        this.update_time = update_time
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String) {
        this.status = status
    }

    fun getVideo(): String? {
        return video
    }

    fun setVideo(video: String) {
        this.video = video
    }

    fun getFm(): String? {
        return fm
    }

    fun setFm(fm: String) {
        this.fm = fm
    }

    fun getLink_url(): String? {
        return link_url
    }

    fun setLink_url(link_url: String) {
        this.link_url = link_url
    }

    fun getPublish_time(): String? {
        return publish_time
    }

    fun setPublish_time(publish_time: String) {
        this.publish_time = publish_time
    }

    fun getView(): String? {
        return view
    }

    fun setView(view: String) {
        this.view = view
    }

    fun getShare(): String? {
        return share
    }

    fun setShare(share: String) {
        this.share = share
    }

    fun getComment(): String? {
        return comment
    }

    fun setComment(comment: String) {
        this.comment = comment
    }

    fun getGood(): String? {
        return good
    }

    fun setGood(good: String) {
        this.good = good
    }

    fun getBookmark(): String? {
        return bookmark
    }

    fun setBookmark(bookmark: String) {
        this.bookmark = bookmark
    }

    fun getShow_uid(): String? {
        return show_uid
    }

    fun setShow_uid(show_uid: String) {
        this.show_uid = show_uid
    }

    fun getFm_play(): String? {
        return fm_play
    }

    fun setFm_play(fm_play: String) {
        this.fm_play = fm_play
    }

    fun getHtml5(): String? {
        return html5
    }

    fun setHtml5(html5: String) {
        this.html5 = html5
    }

    fun getAuthor(): String? {
        return author
    }

    fun setAuthor(author: String) {
        this.author = author
    }

    fun getTpl(): Int {
        return tpl
    }

    fun setTpl(tpl: Int) {
        this.tpl = tpl
    }

    fun getAvatar(): String? {
        return avatar
    }

    fun setAvatar(avatar: String) {
        this.avatar = avatar
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String) {
        this.category = category
    }

    fun getParseXML(): Int {
        return parseXML
    }

    fun setParseXML(parseXML: Int) {
        this.parseXML = parseXML
    }

    fun getTags(): List<TagsBean>? {
        return tags
    }

    fun setTags(tags: List<TagsBean>) {
        this.tags = tags
    }

    fun getHot_comments(): List<HotCommentsBean>? {
        return hot_comments
    }

    fun setHot_comments(hot_comments: List<HotCommentsBean>) {
        this.hot_comments = hot_comments
    }

    class TagsBean : Parcelable {
        var name: String? = null

        override fun describeContents(): Int {
            return 0
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(this.name)
        }

        constructor() {}

        protected constructor(`in`: Parcel) {
            this.name = `in`.readString()
        }

        companion object {

            val CREATOR: Parcelable.Creator<TagsBean> = object : Parcelable.Creator<TagsBean> {
                override fun createFromParcel(source: Parcel): TagsBean {
                    return TagsBean(source)
                }

                override fun newArray(size: Int): Array<TagsBean?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }

    class HotCommentsBean : Parcelable {
        var id: String? = null
        var pid: String? = null
        var uid: String? = null
        var content: String? = null
        var post_id: String? = null
        var update_time: String? = null
        var good: String? = null
        var model: String? = null
        var to_author_name: String? = null
        var under_id: String? = null
        var nickname: String? = null
        var avatar: String? = null

        override fun describeContents(): Int {
            return 0
        }

        override fun writeToParcel(dest: Parcel, flags: Int) {
            dest.writeString(this.id)
            dest.writeString(this.pid)
            dest.writeString(this.uid)
            dest.writeString(this.content)
            dest.writeString(this.post_id)
            dest.writeString(this.update_time)
            dest.writeString(this.good)
            dest.writeString(this.model)
            dest.writeString(this.to_author_name)
            dest.writeString(this.under_id)
            dest.writeString(this.nickname)
            dest.writeString(this.avatar)
        }

        constructor() {}

        protected constructor(`in`: Parcel) {
            this.id = `in`.readString()
            this.pid = `in`.readString()
            this.uid = `in`.readString()
            this.content = `in`.readString()
            this.post_id = `in`.readString()
            this.update_time = `in`.readString()
            this.good = `in`.readString()
            this.model = `in`.readString()
            this.to_author_name = `in`.readString()
            this.under_id = `in`.readString()
            this.nickname = `in`.readString()
            this.avatar = `in`.readString()
        }

        companion object {

            val CREATOR: Parcelable.Creator<HotCommentsBean> = object : Parcelable.Creator<HotCommentsBean> {
                override fun createFromParcel(source: Parcel): HotCommentsBean {
                    return HotCommentsBean(source)
                }

                override fun newArray(size: Int): Array<HotCommentsBean?> {
                    return arrayOfNulls(size)
                }
            }
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(this.id)
        dest.writeString(this.uid)
        dest.writeString(this.name)
        dest.writeString(this.title)
        dest.writeString(this.excerpt)
        dest.writeString(this.lead)
        dest.writeString(this.model)
        dest.writeString(this.position)
        dest.writeString(this.thumbnail)
        dest.writeString(this.create_time)
        dest.writeString(this.update_time)
        dest.writeString(this.status)
        dest.writeString(this.video)
        dest.writeString(this.fm)
        dest.writeString(this.link_url)
        dest.writeString(this.publish_time)
        dest.writeString(this.view)
        dest.writeString(this.share)
        dest.writeString(this.comment)
        dest.writeString(this.good)
        dest.writeString(this.bookmark)
        dest.writeString(this.show_uid)
        dest.writeString(this.fm_play)
        dest.writeString(this.html5)
        dest.writeString(this.author)
        dest.writeInt(this.tpl)
        dest.writeString(this.avatar)
        dest.writeString(this.category)
        dest.writeInt(this.parseXML)
        dest.writeList(this.tags)
        dest.writeList(this.hot_comments)
    }


    val CREATOR: Parcelable.Creator<Item> = object : Parcelable.Creator<Item> {
        override fun createFromParcel(source: Parcel): Item {
            return Item(source)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

    init {
        this.id = `in`.readString()
        this.uid = `in`.readString()
        this.name = `in`.readString()
        this.title = `in`.readString()
        this.excerpt = `in`.readString()
        this.lead = `in`.readString()
        this.model = `in`.readString()
        this.position = `in`.readString()
        this.thumbnail = `in`.readString()
        this.create_time = `in`.readString()
        this.update_time = `in`.readString()
        this.status = `in`.readString()
        this.video = `in`.readString()
        this.fm = `in`.readString()
        this.link_url = `in`.readString()
        this.publish_time = `in`.readString()
        this.view = `in`.readString()
        this.share = `in`.readString()
        this.comment = `in`.readString()
        this.good = `in`.readString()
        this.bookmark = `in`.readString()
        this.show_uid = `in`.readString()
        this.fm_play = `in`.readString()
        this.html5 = `in`.readString()
        this.author = `in`.readString()
        this.tpl = `in`.readInt()
        this.avatar = `in`.readString()
        this.category = `in`.readString()
        this.parseXML = `in`.readInt()
        this.tags = ArrayList()
        `in`.readList(this.tags, TagsBean::class.java.classLoader)
        this.hot_comments = ArrayList()
        `in`.readList(this.hot_comments, HotCommentsBean::class.java.classLoader)
    }


}