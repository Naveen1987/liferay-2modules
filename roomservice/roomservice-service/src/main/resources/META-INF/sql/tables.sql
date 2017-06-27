create table bookedequipment (
	booked_equip_id LONG not null primary key,
	equip_id LONG,
	room_id LONG,
	booked_equip_status BOOLEAN
);

create table equipment (
	equip_id LONG not null primary key,
	equipment_name VARCHAR(75) null,
	equip_quantity INTEGER,
	equip_description VARCHAR(75) null,
	equip_status BOOLEAN
);