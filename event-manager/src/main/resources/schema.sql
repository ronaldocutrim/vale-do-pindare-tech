
CREATE TABLE participants (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE events (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    owner_id UUID NOT NULL REFERENCES participants(id),
    name VARCHAR(150) NOT NULL,
    description TEXT NOT NULL,
    event_date TIMESTAMP NOT NULL,
    total_slots INTEGER NOT NULL CHECK (total_slots > 0),
    location VARCHAR(200),
    active BOOLEAN DEFAULT true,
    created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE registrations (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    event_id UUID NOT NULL REFERENCES events(id),
    participant_id UUID NOT NULL REFERENCES participants(id),
    created_at TIMESTAMP DEFAULT NOW(),
    UNIQUE (event_id, participant_id)
);
