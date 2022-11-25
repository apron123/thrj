select * from movies

select movie_actor from movies

set @rownum:=0;
commit;

select @rownum:=@rownum+1 as no, m.*
from movies m
limit 14,14;

insert into history values('mb_id 001',960,"2022-11-25" );
select * from history;

select * from movies
where movie_seq=(select movie_seq from history where mb_id='mb_id 001' order by history_date desc)

commit;

select mb_pw from members where mb_id='mb_id 001'