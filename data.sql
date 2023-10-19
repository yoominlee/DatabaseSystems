-- User Info Table (Already in 1NF)
CREATE TABLE user_info (
    UserID serial PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Birthday DATE,
    Password VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    UserColor VARCHAR(10)
);

-- Event Info Table (Now represents the events)
CREATE TABLE events (
    EventID serial PRIMARY KEY,
    EventName VARCHAR(255) NOT NULL,
    Description TEXT,
    StartTime TIMESTAMPTZ NOT NULL,
    EndTime TIMESTAMPTZ NOT NULL,
    AllDay BOOLEAN,
    Private BOOLEAN,
    Importance INT
);

-- Event Members Table (Many-to-Many Relationship)
CREATE TABLE event_members (
    EventMemberID serial PRIMARY KEY,
    EventID INT REFERENCES events(EventID),
    UserID INT REFERENCES user_info(UserID)
);

-- Event Creators Table (Associates Users with Event Creation)
CREATE TABLE event_creators (
    EventCreatorID serial PRIMARY KEY,
    EventID INT REFERENCES events(EventID),
    UserID INT REFERENCES user_info(UserID)
);