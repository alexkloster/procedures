ALTER TABLE public.patient ALTER COLUMN sex TYPE VARCHAR(7) USING sex::VARCHAR(7);


ALTER TABLE public.study ALTER COLUMN planned_start_time TYPE TIMESTAMP WITHOUT TIME ZONE USING planned_start_time::TIMESTAMP WITHOUT TIME ZONE;
ALTER TABLE public.study ALTER COLUMN estimated_end_time TYPE TIMESTAMP WITHOUT TIME ZONE USING estimated_end_time::TIMESTAMP WITHOUT TIME ZONE;