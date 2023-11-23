SELECT * FROM acomodacao;

SELECT * FROM hospede;

SELECT * FROM reserva;

SELECT * FROM estadia;

SELECT * FROM hospede WHERE nome = 'Teste';

SELECT * FROM reserva WHERE id_acomodacao = 4 AND (
	-- Nova reserva totalmente dentro do período já marcado
    "2023-11-06" >= check_in AND "2023-11-07" <= check_out
    -- Nova reserva totalmente fora, abrangendo o período já marcado
    OR "2023-11-06" <= check_in AND "2023-11-07" >= check_out
    -- Nova reserva com checkIn dentro do período já marcado
    OR "2023-11-06" > check_in AND "2023-11-06" < check_out
    -- Nova reserva com checkOut dentro do período já marcado
    OR "2023-11-07" > check_in AND "2023-11-07" < check_out
);