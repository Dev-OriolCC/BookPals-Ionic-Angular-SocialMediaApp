create table if not exists posts (
  id bigint primary key generated always as identity,
  user_id bigint not null references users (id),
  content text not null,
  title text not null,
  image text,
  created_at timestamp with time zone default now()
);

create table if not exists likes (
  id bigint primary key generated always as identity,
  user_id bigint not null references users (id),
  post_id bigint not null references posts (id),
  created_at timestamp with time zone default now(),
  unique (user_id, post_id)
);

create table if not exists comments (
  id bigint primary key generated always as identity,
  user_id bigint not null references users (id),
  post_id bigint not null references posts (id),
  content text not null,
  created_at timestamp with time zone default now()
);

