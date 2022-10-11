alter table comments add comment_count int default 0;
ALTER TABLE comments ALTER COLUMN like_count SET DEFAULT 0;