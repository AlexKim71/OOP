-- ============================================
-- INITIAL DATA SETUP / ІНІЦІАЛЬНІ ДАНІ
-- ============================================

-- Insert Hotels / Вставити готелі
INSERT INTO hotels (name, city, address, rating) VALUES
('Grand Hotel Kyiv', 'Kyiv', '123 Main Street, Kyiv, Ukraine', 5),
('Palace Hotel Lviv', 'Lviv', '456 Liberty Avenue, Lviv, Ukraine', 4),
('Star Resort Odesa', 'Odesa', '789 Beach Boulevard, Odesa, Ukraine', 4),
('City Hotel Kharkiv', 'Kharkiv', '321 Central Square, Kharkiv, Ukraine', 3);

-- Insert Amenities / Вставити зручності
INSERT INTO amenities (name, description, hotel_id) VALUES
('WiFi', 'High-speed wireless internet connection', 1),
('Pool', 'Indoor heated swimming pool', 1),
('Gym', 'Fully equipped fitness center', 1),
('Restaurant', 'A la carte restaurant', 1),
('Parking', 'Free underground parking', 2),
('Spa', 'Full-service spa and wellness center', 2),
('Sauna', 'Traditional sauna', 2),
('Business Center', '24/7 business center', 3),
('Bar', 'Rooftop bar with city views', 3),
('Room Service', '24-hour room service', 4);

-- Insert Rooms / Вставити номери
INSERT INTO rooms (number, type, price_per_night, capacity, hotel_id) VALUES
-- Grand Hotel Kyiv Rooms
('101', 'Standard', 80.00, 2, 1),
('102', 'Deluxe', 150.00, 2, 1),
('103', 'Suite', 250.00, 4, 1),
('104', 'Standard', 80.00, 2, 1),
('105', 'Deluxe', 150.00, 2, 1),

-- Palace Hotel Lviv Rooms
('201', 'Standard', 70.00, 2, 2),
('202', 'Deluxe', 130.00, 2, 2),
('203', 'Suite', 220.00, 4, 2),
('204', 'Standard', 70.00, 2, 2),

-- Star Resort Odesa Rooms
('301', 'Standard', 75.00, 2, 3),
('302', 'Deluxe', 140.00, 2, 3),
('303', 'Suite', 230.00, 4, 3),
('304', 'Standard', 75.00, 2, 3),

-- City Hotel Kharkiv Rooms
('401', 'Standard', 60.00, 2, 4),
('402', 'Deluxe', 120.00, 2, 4),
('403', 'Standard', 60.00, 2, 4);

-- Insert Guests / Вставити гостей
INSERT INTO guests (first_name, last_name, email, phone) VALUES
('Ivan', 'Ivanov', 'ivan@example.com', '+380501234567'),
('Maria', 'Shevchenko', 'maria@example.com', '+380501234568'),
('Petro', 'Kovalenko', 'petro@example.com', '+380501234569'),
('Olga', 'Volkova', 'olga@example.com', '+380501234570'),
('Dmitry', 'Popov', 'dmitry@example.com', '+380501234571'),
('Anna', 'Sokolov', 'anna@example.com', '+380501234572'),
('Sergey', 'Petrov', 'sergey@example.com', '+380501234573'),
('Elena', 'Morozov', 'elena@example.com', '+380501234574');

-- Insert Bookings / Вставити бронювання
INSERT INTO bookings (check_in_date, check_out_date, status, room_id, guest_id) VALUES
('2024-05-01', '2024-05-05', 'ACTIVE', 1, 1),
('2024-05-02', '2024-05-06', 'ACTIVE', 2, 2),
('2024-05-03', '2024-05-08', 'COMPLETED', 3, 3),
('2024-05-10', '2024-05-15', 'ACTIVE', 4, 4),
('2024-05-12', '2024-05-16', 'CANCELLED', 5, 5),
('2024-05-20', '2024-05-25', 'ACTIVE', 6, 6),
('2024-05-25', '2024-05-28', 'ACTIVE', 7, 7),
('2024-06-01', '2024-06-05', 'COMPLETED', 8, 8);

-- Insert Room Amenities / Вставити зручності номерів
INSERT INTO room_amenities (room_id, amenity_id) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 2), (2, 3), (2, 4),
(3, 1), (3, 2), (3, 3), (3, 4),
(6, 5), (6, 6), (6, 7),
(7, 5), (7, 6),
(8, 8), (8, 9);

