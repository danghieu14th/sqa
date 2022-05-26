insert into roles (id, name) values (1, 'ROLE_ADMIN');
insert into roles (id, name) values (2, 'ROLE_USER');

insert into categories (id, description, name, picture) values (1, 'Single Room with free breakfast for one person or two start from $500 for night up to $1999.', 'Single Room', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRyiYy-c4SwUAK1juLBJcOBAW-U_d4J6anI2J2G0XLPSNSYqZ0f' );
insert into categories (id, description, name, picture) values (2, 'Double Room with free breakfast for three persons or four start from $1000 for night up to $2999.', 'Double Room', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRw-gDCLHq4AwYiYbyWEAKasXaYecJFnVmVBeUbCOcxuYcAgA4k' );
insert into categories (id, description, name, picture) values (3, 'Family Room with free breakfast for four persons or five start from $1300 for night up to $3299.', 'Family Room', 'https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTPqXgC0aSM-X6SVPxbLMBz9YZBeb34qHvNLt6cwOV9g5Ohl6wR' );
insert into categories (id, description, name, picture) values (4, 'Honeymoon Suite with breakfast and ready for any surprises and customized equipment and start from $1000 for night up to $4999.  ', 'Honeymoon Suite', 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQ9NImj5CfeVP9U37qsnbWG_SqD6H_D9SbIet7sqJ5lC_WlC-7z' );

insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (1, '300000.0', '0.0', 'https://www.collinsdictionary.com/images/full/singleroom_713511961_1000.jpg', 'SR001', '0', '1' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (2, '350000.0', '0.0', 'https://webbox.imgix.net/images/owvecfmxulwbfvxm/c56a0c0d-8454-431a-9b3e-f420c72e82e3.jpg', 'SR002', '0', '1' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (3, '400000.0', '0.0', 'https://hotelvilnia.lt/wp-content/uploads/2018/06/DSC07685-HDR-Edit-Edit.jpg', 'SR003', '0', '1' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (4, '500000.0', '0.0', 'https://www.hotelparadies.com/fileadmin/_optimized_/1024/1087016/csm_paradies-latsch-wohnen-single-room-2_eb2aa9b06f.jpg', 'SR004', '0', '1' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (5, '400000.0', '100000.0', 'https://danang.huongnghiepaau.com/images/quantri/twin-room-la-gi.jpg', 'DR001', '0', '2' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (6, '600000.0', '100000.0', 'https://cdn.cet.edu.vn/wp-content/uploads/2019/05/twin-room-la-loai-phong-co-2-giuong-lon.jpg', 'DR002', '0', '2' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (7, '550000.0', '150000.0', 'http://static1.eskypartners.com/travelguide/twin-room-double-room-jaka-roznica.jpg', 'DR003', '0', '2' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (8, '600000.0', '120000.0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSblmC3eJfSgutUoGM4UuHD6hwuGwBHrSpoWw&usqp=CAU', 'DR004', '0', '2' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (9, '700000.0', '200000.0', 'https://ksassets.timeincuk.net/wp/uploads/sites/56/2021/05/Family-Living-room-Ideal-Home.jpg', 'FR001', '0', '3' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (10, '500000.0', '100000.0', 'https://i0.wp.com/www.khov.com/blog/wp-content/uploads/2020/04/30993_Aspire-at-Ashley-Pointe_Ellwood_Family-Room.jpg?resize=768%2C491&ssl=1', 'FR002', '0', '3' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (11, '900000.0', '200000.0', 'http://sacramento.cbslocal.com/wp-content/uploads/sites/15909776/2013/02/lake-natoma-honeymoon.jpg', 'HM001', '0', '4' );
insert into rooms (id, adult_price, child_price, picture, room_code, state, category_id) values (12, '1000000.0', '300000.0', 'https://media-cdn.tripadvisor.com/media/photo-s/09/1e/4a/1e/white-pearl-suites.jpg', 'HM002', '0', '4' );

