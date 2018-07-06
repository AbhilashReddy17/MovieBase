package com.osiragames.moviebase.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieVideos implements Serializable, Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    public final static Parcelable.Creator<MovieVideos> CREATOR = new Creator<MovieVideos>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MovieVideos createFromParcel(Parcel in) {
            return new MovieVideos(in);
        }

        public MovieVideos[] newArray(int size) {
            return (new MovieVideos[size]);
        }

    };
    private final static long serialVersionUID = -7448409581064711399L;

    protected MovieVideos(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (Result.class.getClassLoader()));
    }

    public MovieVideos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }

    public class Result implements Serializable, Parcelable {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("iso_639_1")
        @Expose
        private String iso6391;
        @SerializedName("iso_3166_1")
        @Expose
        private String iso31661;
        @SerializedName("key")
        @Expose
        private String key;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("site")
        @Expose
        private String site;
        @SerializedName("size")
        @Expose
        private Integer size;
        @SerializedName("type")
        @Expose
        private String type;
        public final Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Result createFromParcel(Parcel in) {
                return new Result(in);
            }

            public Result[] newArray(int size) {
                return (new Result[size]);
            }

        };
        private final static long serialVersionUID = 6968870792877437879L;

        protected Result(Parcel in) {
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.iso6391 = ((String) in.readValue((String.class.getClassLoader())));
            this.iso31661 = ((String) in.readValue((String.class.getClassLoader())));
            this.key = ((String) in.readValue((String.class.getClassLoader())));
            this.name = ((String) in.readValue((String.class.getClassLoader())));
            this.site = ((String) in.readValue((String.class.getClassLoader())));
            this.size = ((Integer) in.readValue((Integer.class.getClassLoader())));
            this.type = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Result() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso6391() {
            return iso6391;
        }

        public void setIso6391(String iso6391) {
            this.iso6391 = iso6391;
        }

        public String getIso31661() {
            return iso31661;
        }

        public void setIso31661(String iso31661) {
            this.iso31661 = iso31661;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public Integer getSize() {
            return size;
        }

        public void setSize(Integer size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(id);
            dest.writeValue(iso6391);
            dest.writeValue(iso31661);
            dest.writeValue(key);
            dest.writeValue(name);
            dest.writeValue(site);
            dest.writeValue(size);
            dest.writeValue(type);
        }

        public int describeContents() {
            return 0;
        }

    }
}
