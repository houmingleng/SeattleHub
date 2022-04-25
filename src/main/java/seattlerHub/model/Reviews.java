package seattlerHub.model;

import java.sql.Timestamp;

public class Reviews {
  protected Integer reviewId;
  protected Timestamp created;
  protected String content;
  protected Double rating;
  protected Users users;
  protected Housing housing;

  public Reviews(Integer reviewId, Timestamp created, String content, Double rating, Users users,
      Housing housing) {
    this.reviewId = reviewId;
    this.created = created;
    this.content = content;
    this.rating = rating;
    this.users = users;
    this.housing = housing;
  }

  public Reviews(Timestamp created, String content, Double rating, Users users, Housing housing) {
    this.created = created;
    this.content = content;
    this.rating = rating;
    this.users = users;
    this.housing = housing;
  }

  public Integer getReviewId() {
    return reviewId;
  }

  public void setReviewId(Integer reviewId) {
    this.reviewId = reviewId;
  }

  public Timestamp getCreated() {
    return created;
  }

  public void setCreated(Timestamp created) {
    this.created = created;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Double getRating() {
    return rating;
  }

  public void setRating(Double rating) {
    this.rating = rating;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  public Housing getHousing() {
    return housing;
  }

  public void setHousing(Housing housing) {
    this.housing = housing;
  }
}
