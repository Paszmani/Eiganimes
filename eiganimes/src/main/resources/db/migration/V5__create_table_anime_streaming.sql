CREATE TABLE anime_streaming (
    anime_id INTEGER,
    streaming_id INTEGER,
    CONSTRAINT fk_anime_streaming_anime FOREIGN KEY(anime_id) REFERENCES anime(id),
    CONSTRAINT fk_anime_streaming_streaming FOREIGN KEY(streaming_id) REFERENCES streaming(id)
);