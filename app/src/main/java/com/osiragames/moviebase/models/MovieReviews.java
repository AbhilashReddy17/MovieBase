package com.osiragames.moviebase.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class MovieReviews {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    public final static Parcelable.Creator<MovieReviews> CREATOR = new Parcelable.Creator<MovieReviews>() {


        @SuppressWarnings({
                "unchecked"
        })
        public MovieReviews createFromParcel(Parcel in) {
            return new MovieReviews(in);
        }

        public MovieReviews[] newArray(int size) {
            return (new MovieReviews[size]);
        }

    }
            ;
    private final static long serialVersionUID = -3024496606172643323L;

    protected MovieReviews(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (Result.class.getClassLoader()));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public MovieReviews() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(page);
        dest.writeList(results);
        dest.writeValue(totalPages);
        dest.writeValue(totalResults);
    }

    public int describeContents() {
        return 0;
    }

    public class Result implements Serializable, Parcelable
    {

        @SerializedName("author")
        @Expose
        private String author;
        @SerializedName("content")
        @Expose
        private String content;
        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("url")
        @Expose
        private String url;
        public final  Parcelable.Creator<Result> CREATOR = new Creator<Result>() {


            @SuppressWarnings({
                    "unchecked"
            })
            public Result createFromParcel(Parcel in) {
                return new Result(in);
            }

            public Result[] newArray(int size) {
                return (new Result[size]);
            }

        }
                ;
        private final static long serialVersionUID = -368720328025786966L;

        protected Result(Parcel in) {
            this.author = ((String) in.readValue((String.class.getClassLoader())));
            this.content = ((String) in.readValue((String.class.getClassLoader())));
            this.id = ((String) in.readValue((String.class.getClassLoader())));
            this.url = ((String) in.readValue((String.class.getClassLoader())));
        }

        public Result() {
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeValue(author);
            dest.writeValue(content);
            dest.writeValue(id);
            dest.writeValue(url);
        }

        public int describeContents() {
            return 0;
        }

    }
}
