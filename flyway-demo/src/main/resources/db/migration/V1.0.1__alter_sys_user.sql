ALTER TABLE "public"."sys_user"
  ADD COLUMN "nick_name" varchar(255);

COMMENT ON COLUMN "public"."sys_user"."nick_name" IS '昵称';