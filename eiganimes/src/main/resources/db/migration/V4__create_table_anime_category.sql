CREATE TABLE anime_category (
    anime_id INTEGER,
    category_id INTEGER,
    CONSTRAINT fk_anime_category_anime FOREIGN KEY(anime_id) REFERENCES anime(id),
    CONSTRAINT fk_anime_category_category FOREIGN KEY(category_id) REFERENCES category(id)
);